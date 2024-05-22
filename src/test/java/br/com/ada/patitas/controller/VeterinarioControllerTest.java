package br.com.ada.patitas.controller;

import static br.com.ada.patitas.DataVeterinario.listaVeterinario;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import br.com.ada.patitas.DataVeterinario;
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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
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


    @Test
    public void deveListarTodosVeterinario() throws Exception {
        List<Veterinario> veterinarios = DataVeterinario.listaVeterinario();
        when(veterinarioService.findAll()).thenReturn(veterinarios);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/veterinario"))
                .andExpect(status().isOk()).andReturn();

        List<VeterinarioDto> responseDto = objectMapper.readValue(result.getResponse().getContentAsString(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, VeterinarioDto.class));
        assertEquals(veterinarios.size(), responseDto.size());
    }

    @Test
    public void deveEncontrarVeterinarioPorId() throws Exception {

        Veterinario veterinario = DataVeterinario.veterinario();
        String veterinarioJson = objectMapper.writeValueAsString(veterinario);

        when(veterinarioService.findById(1L)).thenReturn(Optional.of(veterinario));
        mockMvc.perform(get("/veterinario/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void deveCadastrarUmVeterinario() throws Exception {

        Veterinario veterinario = DataVeterinario.veterinario();
        String veterinarioJson = objectMapper.writeValueAsString(veterinario);

        mockMvc.perform(post("/veterinario")
                .contentType("application/json")
                .content(veterinarioJson))
                .andExpect(status().isCreated());
        verify(veterinarioService.save(any(Veterinario.class)));
    }

    @Test

    public void deveAtualizarUmVeterinario() throws Exception {
        Veterinario veterinario = DataVeterinario.veterinario();
        String veterinarioJson = objectMapper.writeValueAsString(veterinario);
        when(veterinarioService.update(any(Long.class), any(Veterinario.class))).thenReturn(Optional.of(new Veterinario()));
        mockMvc.perform(MockMvcRequestBuilders.put("/veterinario/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(veterinarioJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deveDeletarUmVeterinario() throws Exception {
        mockMvc.perform(delete("/veterinario/1"))
                .andExpect(status().isNoContent());
        verify(veterinarioService).delete(1L);
    }
}