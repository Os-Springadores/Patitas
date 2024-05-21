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
<<<<<<< HEAD

=======
import br.com.ada.patitas.serviceimpl.PacienteServiceImpl;
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee

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
<<<<<<< HEAD
    public void deveListarPacientes() {
        List<Paciente> paciente = new ArrayList<>();
        when(pacienteRepository.findAll()).thenReturn(paciente);

        List<Paciente> pacientes = pacienteService.findAll();

        assertEquals(paciente, pacientes);
    }

    @Test
    public void deveProcurarPacientePorId() {
=======
    public void testFindAll() {
   
        List<Paciente> pacientes = new ArrayList<>();
        when(pacienteRepository.findAll()).thenReturn(pacientes);

     
        List<Paciente> result = pacienteService.findAll();

  
        assertEquals(pacientes, result);
    }

    @Test
    public void testFindById() {
  
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));

<<<<<<< HEAD
        Optional<Paciente> pacienteOptional = pacienteService.findById(1L);

        assertTrue(pacienteOptional.isPresent());
        assertEquals(paciente, pacienteOptional.get());
    }

    @Test
    public void deveCadastrarUmPaciente() {
=======
       
        Optional<Paciente> result = pacienteService.findById(1L);

   
        assertTrue(result.isPresent());
        assertEquals(paciente, result.get());
    }

    @Test
    public void testSave() {

>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        Paciente paciente = new Paciente();
        when(pacienteRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(pacienteRepository.save(paciente)).thenReturn(paciente);

<<<<<<< HEAD
        Paciente result = pacienteService.save(paciente);

=======
    
        Paciente result = pacienteService.save(paciente);

   
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        assertEquals(paciente, result);
    }

    @Test
<<<<<<< HEAD
    public void deveSalvarPacienteComIdExistente() {
=======
    public void testSaveWithExistingId() {
   
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));

<<<<<<< HEAD
        assertThrows(PacienteJaExisteException.class, () -> pacienteService.save(paciente));
    }

    @Test
    public void deveAtualizarUmPaciente() {
        Paciente paciente = new Paciente();
        paciente.getId();
        Paciente pacienteAtualizado = new Paciente();
        pacienteAtualizado.setNome("taruga");
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));
        when(pacienteRepository.save(paciente)).thenReturn(paciente);

        Optional<Paciente> result = pacienteService.update(1L, pacienteAtualizado);

        assertTrue(result.isPresent());
        assertEquals(pacienteAtualizado.getNome(), result.get().getNome());
    }

    @Test
    public void deveDeletarUmPaciente() {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));

        pacienteService.delete(1L);

        verify(pacienteRepository).delete(paciente);
    }

    @Test
    public void validaExcluirPacienteComIdInexistente() {
        when(pacienteRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(PacienteJaExisteException.class, () -> pacienteService.delete(1L));
=======
 
        assertThrows(PacienteJaExisteException.class, () -> pacienteService.save(paciente));
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
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
