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

@WebMvcTest(PacienteController.class)
public class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PacienteService pacienteService;

    @InjectMocks
    private PacienteController pacienteController;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() throws Exception {
        List<Paciente> pacientes = Arrays.asList(new Paciente(), new Paciente());
        when(pacienteService.findAll()).thenReturn(pacientes);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/paciente"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        List<PacienteDto> responseDto = objectMapper.readValue(result.getResponse().getContentAsString(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, PacienteDto.class));
        assertEquals(pacientes.size(), responseDto.size());
    }

    @Test
    public void testFindById() throws Exception {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        when(pacienteService.findById(1L)).thenReturn(Optional.of(paciente));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/paciente/1"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        PacienteDto responseDto = objectMapper.readValue(result.getResponse().getContentAsString(),
                PacienteDto.class);
        assertEquals(paciente.getId(), responseDto.getId());
    }

    @Test
    public void testSave() throws Exception {
        PacienteDto pacienteDto = new PacienteDto();
        pacienteDto.setNome("Nome do Paciente");

        String requestBody = objectMapper.writeValueAsString(pacienteDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/paciente")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
            .andExpect(status().isCreated());
    }

    @Test
    public void testUpdate() throws Exception {
        PacienteDto pacienteDto = new PacienteDto();
        pacienteDto.setId(1L);
        pacienteDto.setNome("Novo Nome do Paciente");

        String requestBody = objectMapper.writeValueAsString(pacienteDto);

        when(pacienteService.update(any(Long.class), any(Paciente.class)))
            .thenReturn(Optional.of(new Paciente()));

        mockMvc.perform(MockMvcRequestBuilders.put("/paciente/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
            .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/paciente/1"))
            .andExpect(status().isNoContent());
    }
}
