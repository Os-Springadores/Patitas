import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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

@WebMvcTest(VeterinarioController.class)
public class VeterinarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VeterinarioService veterinarioService;

    @InjectMocks
    private VeterinarioController veterinarioController;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() throws Exception {
        List<Veterinario> veterinarios = Arrays.asList(new Veterinario(), new Veterinario());
        when(veterinarioService.findAll()).thenReturn(veterinarios);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/veterinario"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        List<VeterinarioDto> responseDto = objectMapper.readValue(result.getResponse().getContentAsString(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, VeterinarioDto.class));
        assertEquals(veterinarios.size(), responseDto.size());
    }

    @Test
    public void testFindById() throws Exception {
        Veterinario veterinario = new Veterinario();
        veterinario.setId(1L);
        when(veterinarioService.findById(1L)).thenReturn(Optional.of(veterinario));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/veterinario/1"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        VeterinarioDto responseDto = objectMapper.readValue(result.getResponse().getContentAsString(),
                VeterinarioDto.class);
        assertEquals(veterinario.getId(), responseDto.getId());
    }

    @Test
    public void testSave() throws Exception {
        VeterinarioDto veterinarioDto = new VeterinarioDto();
        veterinarioDto.setNome("Nome do Veterinario");
        veterinarioDto.setEspecialidade("Especialidade do Veterinario");

        String requestBody = objectMapper.writeValueAsString(veterinarioDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/veterinario")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
            .andExpect(status().isCreated());
    }

    @Test
    public void testUpdate() throws Exception {
        VeterinarioDto veterinarioDto = new VeterinarioDto();
        veterinarioDto.setId(1L);
        veterinarioDto.setNome("Novo Nome do Veterinario");
        veterinarioDto.setEspecialidade("Nova Especialidade do Veterinario");

        String requestBody = objectMapper.writeValueAsString(veterinarioDto);

        when(veterinarioService.update(any(Long.class), any(Veterinario.class)))
            .thenReturn(Optional.of(new Veterinario()));

        mockMvc.perform(MockMvcRequestBuilders.put("/veterinario/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
            .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/veterinario/1"))
            .andExpect(status().isNoContent());
    }
}
