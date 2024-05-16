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
        List<Paciente> pacientes = new ArrayList<>();
        when(pacienteRepository.findAll()).thenReturn(pacientes);

        List<Paciente> result = pacienteService.findAll();

        assertEquals(pacientes, result);
    }

    @Test
    public void testFindById() {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));

        Optional<Paciente> result = pacienteService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(paciente, result.get());
    }

    @Test
    public void testSave() {
        Paciente paciente = new Paciente();
        when(pacienteRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(pacienteRepository.save(paciente)).thenReturn(paciente);

        Paciente result = pacienteService.save(paciente);

        assertEquals(paciente, result);
    }

    @Test
    public void testSaveWithExistingId() {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));

        assertThrows(PacienteJaExisteException.class, () -> pacienteService.save(paciente));
    }

    @Test
    public void testUpdate() {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        Paciente pacienteAtualizado = new Paciente();
        pacienteAtualizado.setNome("Novo Nome");
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));
        when(pacienteRepository.save(paciente)).thenReturn(paciente);

        Optional<Paciente> result = pacienteService.update(1L, pacienteAtualizado);

        assertTrue(result.isPresent());
        assertEquals(pacienteAtualizado.getNome(), result.get().getNome());
    }

    @Test
    public void testDelete() {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));

        pacienteService.delete(1L);

        verify(pacienteRepository).delete(paciente);
    }

    @Test
    public void testDeleteNonexistentId() {
        when(pacienteRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(PacienteJaExisteException.class, () -> pacienteService.delete(1L));
    }
}