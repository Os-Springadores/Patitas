package br.com.ada.patitas.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.ada.patitas.exception.VeterinarioJaExisteException;
import br.com.ada.patitas.model.Veterinario;
import br.com.ada.patitas.repository.VeterinarioRepository;
import br.com.ada.patitas.serviceimpl.VeterinarioServiceImpl;

public class VeterinarioServiceImplTest {

    @Mock
    private VeterinarioRepository veterinarioRepository;

    @InjectMocks
    private VeterinarioServiceImpl veterinarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Given
        List<Veterinario> veterinarios = new ArrayList<>();
        when(veterinarioRepository.findAll()).thenReturn(veterinarios);

        // When
        List<Veterinario> result = veterinarioService.findAll();

        // Then
        assertEquals(veterinarios, result);
    }

    @Test
    public void testFindById() {
        // Given
        Veterinario veterinario = new Veterinario();
        veterinario.setId(1L);
        when(veterinarioRepository.findById(1L)).thenReturn(Optional.of(veterinario));

        // When
        Optional<Veterinario> result = veterinarioService.findById(1L);

        // Then
        assertTrue(result.isPresent());
        assertEquals(veterinario, result.get());
    }

    @Test
    public void testSave() {
        // Given
        Veterinario veterinario = new Veterinario();
        when(veterinarioRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(veterinarioRepository.save(veterinario)).thenReturn(veterinario);

        // When
        Veterinario result = veterinarioService.save(veterinario);

        // Then
        assertEquals(veterinario, result);
    }

    @Test
    public void testSaveWithExistingId() {
        // Given
        Veterinario veterinario = new Veterinario();
        veterinario.setId(1L);
        when(veterinarioRepository.findById(1L)).thenReturn(Optional.of(veterinario));

        // When & Then
        assertThrows(VeterinarioJaExisteException.class, () -> veterinarioService.save(veterinario));
    }

    @Test
    public void testUpdate() {
        // Given
        Veterinario veterinario = new Veterinario();
        veterinario.setId(1L);
        Veterinario veterinarioAtualizado = new Veterinario();
        veterinarioAtualizado.setNome("Novo Nome");
        when(veterinarioRepository.findById(1L)).thenReturn(Optional.of(veterinario));
        when(veterinarioRepository.save(veterinarioAtualizado)).thenReturn(veterinarioAtualizado);

        // When
        Optional<Veterinario> result = veterinarioService.update(1L, veterinarioAtualizado);

        // Then
        assertTrue(result.isPresent());
        assertEquals(veterinarioAtualizado.getNome(), result.get().getNome());
    }

    @Test
    public void testDelete() {
        // Given
        Veterinario veterinario = new Veterinario();
        veterinario.setId(1L);
        when(veterinarioRepository.findById(1L)).thenReturn(Optional.of(veterinario));

        // When
        veterinarioService.delete(1L);

        // Then
        verify(veterinarioRepository).delete(veterinario);
    }

    @Test
    public void testDeleteNonexistentId() {
        // Given
        when(veterinarioRepository.findById(1L)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(VeterinarioJaExisteException.class, () -> veterinarioService.delete(1L));
    }
}
