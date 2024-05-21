package br.com.ada.patitas.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import br.com.ada.patitas.dto.VeterinarioDto;
import br.com.ada.patitas.model.Especialidade;
import br.com.ada.patitas.model.Veterinario;
import br.com.ada.patitas.service.VeterinarioService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


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
    public void deveListarTodos() throws Exception {
        List<Veterinario> veterinarios = Arrays.asList(new Veterinario(), new Veterinario());
        when(veterinarioService.findAll()).thenReturn(veterinarios);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/veterinario"))
                .andExpect(status().isOk()).andReturn();

        List<VeterinarioDto> responseDto = objectMapper.readValue(result.getResponse().getContentAsString(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, VeterinarioDto.class));
        assertEquals(veterinarios.size(), responseDto.size());
    }

    @Test
    public void deveEncontrarVeterinarioPorId() throws Exception {
        Veterinario veterinario = new Veterinario();
        veterinario.getId();
        when(veterinarioService.findById(1L)).thenReturn(Optional.of(veterinario));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/veterinario/1"))
                .andExpect(status().isOk()).andReturn();

        Veterinario veterinarioResponse = objectMapper.readValue(result.getResponse().getContentAsString(),
                Veterinario.class);
        assertEquals(veterinario.getId(), veterinarioResponse);
    }

    @Test
    public void deveCadastrarUmVeterinario() throws Exception {
        VeterinarioDto veterinarioDto = new VeterinarioDto();
        veterinarioDto.getNome();
        veterinarioDto.getEspecialidade();

        String requestBody = objectMapper.writeValueAsString(veterinarioDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/veterinario")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isCreated());
    }

    @Test
    public void deveAtualizarUmVeterinario() throws Exception {
        VeterinarioDto veterinarioDto = new VeterinarioDto();
        veterinarioDto.setNome("Israel");
        veterinarioDto.setEspecialidade(Especialidade.DERMATOLOGIA);

        String requestBody = objectMapper.writeValueAsString(veterinarioDto);

        when(veterinarioService.update(any(Long.class), any(Veterinario.class)))
                .thenReturn(Optional.of(new Veterinario()));

        mockMvc.perform(MockMvcRequestBuilders.put("/veterinario/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void deveDeletarUmVeterinario() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/veterinario/1"))
                .andExpect(status().isNoContent());
    }
}