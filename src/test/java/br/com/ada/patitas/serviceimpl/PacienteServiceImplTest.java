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

import br.com.ada.patitas.exception.PacienteJaExisteException;
import br.com.ada.patitas.model.Paciente;
import br.com.ada.patitas.repository.PacienteRepository;
import br.com.ada.patitas.serviceimpl.PacienteServiceImpl;

public class PacienteServiceImplTest {

    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private PacienteServiceImpl pacienteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Given
        List<Paciente> pacientes = new ArrayList<>();
        when(pacienteRepository.findAll()).thenReturn(pacientes);

        // When
        List<Paciente> result = pacienteService.findAll();

        // Then
        assertEquals(pacientes, result);
    }

    @Test
    public void testFindById() {
        // Given
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));

        // When
        Optional<Paciente> result = pacienteService.findById(1L);

        // Then
        assertTrue(result.isPresent());
        assertEquals(paciente, result.get());
    }

    @Test
    public void testSave() {
        // Given
        Paciente paciente = new Paciente();
        when(pacienteRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(pacienteRepository.save(paciente)).thenReturn(paciente);

        // When
        Paciente result = pacienteService.save(paciente);

        // Then
        assertEquals(paciente, result);
    }

    @Test
    public void testSaveWithExistingId() {
        // Given
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));

        // When & Then
        assertThrows(PacienteJaExisteException.class, () -> pacienteService.save(paciente));
    }

    @Test
    public void testUpdate() {
        // Given
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        Paciente pacienteAtualizado = new Paciente();
        pacienteAtualizado.setNome("Novo Nome");
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));
        when(pacienteRepository.save(paciente)).thenReturn(paciente);

        // When
        Optional<Paciente> result = pacienteService.update(1L, pacienteAtualizado);

        // Then
        assertTrue(result.isPresent());
        assertEquals(pacienteAtualizado.getNome(), result.get().getNome());
    }

    @Test
    public void testDelete() {
        // Given
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));

        // When
        pacienteService.delete(1L);

        // Then
        verify(pacienteRepository).delete(paciente);
    }

    @Test
    public void testDeleteNonexistentId() {
        // Given
        when(pacienteRepository.findById(1L)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(PacienteJaExisteException.class, () -> pacienteService.delete(1L));
    }
}
