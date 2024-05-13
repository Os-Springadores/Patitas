package br.com.ada.patitas.controller;

import br.com.ada.patitas.model.Veterinario;
import br.com.ada.patitas.service.VeterinarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VeterinarioControllerTest {

    @Mock
    private VeterinarioService veterinarioService;

    @InjectMocks
    private VeterinarioController veterinarioController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testBuscarTodosVeterinarios() {
        List<Veterinario> veterinarios = new ArrayList<>();
        when(veterinarioService.buscarTodosVeterinarios()).thenReturn(veterinarios);

        ResponseEntity<List<Veterinario>> response = veterinarioController.buscarTodosVeterinarios();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(veterinarios, response.getBody());
    }

    @Test
    public void testBuscarVeterinarioPorId() {
        Veterinario veterinario = new Veterinario();
        Long id = 1L;
        when(veterinarioService.buscarVeterinarioPorId(id)).thenReturn(Optional.of(veterinario));

        ResponseEntity<Veterinario> response = veterinarioController.buscarVeterinarioPorId(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(veterinario, response.getBody());
    }

    @Test
    public void testCadastrarVeterinario() {
        Veterinario veterinario = new Veterinario();
        when(veterinarioService.cadastrarVeterinario(veterinario)).thenReturn(veterinario);

        ResponseEntity<Veterinario> response = veterinarioController.cadastrarVeterinario(veterinario);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(veterinario, response.getBody());
    }

    @Test
    public void testAtualizarVeterinario() {
        Long id = 1L;
        Veterinario veterinario = new Veterinario();
        veterinario.setId(id);
        when(veterinarioService.buscarVeterinarioPorId(id)).thenReturn(Optional.of(veterinario));

        ResponseEntity<Void> response = veterinarioController.atualizarVeterinario(id, veterinario);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void testDeletarVeterinario() {
        Long id = 1L;
        doNothing().when(veterinarioService).deletarVeterinario(id);

        ResponseEntity<Void> response = veterinarioController.deletarVeterinario(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}