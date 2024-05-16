package br.com.ada.patitas.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.com.ada.patitas.controller.VeterinarioController;
import br.com.ada.patitas.model.Veterinario;
import br.com.ada.patitas.service.VeterinarioService;

@SpringBootTest
@AutoConfigureMockMvc
public class VeterinarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VeterinarioService veterinarioService;

    @InjectMocks
    private VeterinarioController veterinarioController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBuscarTodosVeterinarios() throws Exception {
        // Given
        List<Veterinario> veterinarios = new ArrayList<>();
        when(veterinarioService.findAll()).thenReturn(veterinarios);

        // When & Then
        mockMvc.perform(get("/veterinario"))
                .andExpect(status().isOk());
    }

    @Test
    public void deveRetornarNaoEncontradoSeVeterinarioNaoExiste() throws Exception {
        // Given
        when(veterinarioService.findById(anyLong())).thenReturn(Optional.empty());

        // When & Then
        mockMvc.perform(get("/veterinario/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCadastrarVeterinario() throws Exception {
        // Given
        Veterinario veterinario = new Veterinario();

        // When
        when(veterinarioService.save(any(Veterinario.class))).thenReturn(veterinario);

        // Then
        mockMvc.perform(post("/veterinario")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeletarVeterinario() throws Exception {
        // When & Then
        mockMvc.perform(delete("/veterinario/1"))
                .andExpect(status().isNoContent());

        // Verify if the delete method was called with the correct argument
        verify(veterinarioService).delete(1L);
    }
}
