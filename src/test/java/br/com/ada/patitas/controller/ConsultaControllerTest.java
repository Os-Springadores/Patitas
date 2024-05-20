import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ConsultaController.class)
public class ConsultaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsultaService consultaService;

    @MockBean
    private HorariosDisponiveisRepository horariosDisponiveisRepository;

    @MockBean
    private VeterinarioRepository veterinarioRepository;

    @InjectMocks
    private ConsultaController consultaController;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() throws Exception {
        List<Consulta> consultas = Arrays.asList(new Consulta(), new Consulta());
        when(consultaService.findAll()).thenReturn(consultas);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/consulta"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        List<ConsultaDto> responseDto = objectMapper.readValue(result.getResponse().getContentAsString(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, ConsultaDto.class));
        assertEquals(consultas.size(), responseDto.size());
    }

    @Test
    public void testFindById() throws Exception {
        Consulta consulta = new Consulta();
        consulta.setId(1L);
        when(consultaService.findById(1L)).thenReturn(Optional.of(consulta));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/consulta/1"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        ConsultaDto responseDto = objectMapper.readValue(result.getResponse().getContentAsString(),
                ConsultaDto.class);
        assertEquals(consulta.getId(), responseDto.getId());
    }

    @Test
    public void testSave() throws Exception {
        when(horariosDisponiveisRepository.findById(any(Long.class))).thenReturn(Optional.of(new HorariosDisponiveis()));
        when(veterinarioRepository.findById(any(Long.class))).thenReturn(Optional.of(new Veterinario()));

        ConsultaDto consultaDto = new ConsultaDto();

        String requestBody = objectMapper.writeValueAsString(consultaDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/consulta")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
            .andExpect(status().isCreated());
    }

    @Test
    public void testUpdate() throws Exception {
        ConsultaDto consultaDto = new ConsultaDto();
        consultaDto.setId(1L);

        String requestBody = objectMapper.writeValueAsString(consultaDto);

        when(consultaService.update(any(Long.class), any(Consulta.class))).thenReturn(Optional.of(new Consulta()));

        mockMvc.perform(MockMvcRequestBuilders.put("/consulta/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
            .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/consulta/1"))
            .andExpect(status().isNoContent());
    }
}
