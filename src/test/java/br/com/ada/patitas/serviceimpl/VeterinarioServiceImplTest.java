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
<<<<<<< HEAD
=======
import br.com.ada.patitas.serviceimpl.VeterinarioServiceImpl;
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee

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
<<<<<<< HEAD
    public void deveListarTodosPacientes() {
        List<Veterinario> veterinarios = new ArrayList<>();
        when(veterinarioRepository.findAll()).thenReturn(veterinarios);

        List<Veterinario> result = veterinarioService.findAll();

=======
    public void testFindAll() {

        List<Veterinario> veterinarios = new ArrayList<>();
        when(veterinarioRepository.findAll()).thenReturn(veterinarios);

  
        List<Veterinario> result = veterinarioService.findAll();

 
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        assertEquals(veterinarios, result);
    }

    @Test
<<<<<<< HEAD
    public void deveProcurarVeterinarioPorId() {
=======
    public void testFindById() {
      
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        Veterinario veterinario = new Veterinario();
        veterinario.setId(1L);
        when(veterinarioRepository.findById(1L)).thenReturn(Optional.of(veterinario));

<<<<<<< HEAD
        Optional<Veterinario> result = veterinarioService.findById(1L);

=======
   
        Optional<Veterinario> result = veterinarioService.findById(1L);

  
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        assertTrue(result.isPresent());
        assertEquals(veterinario, result.get());
    }

    @Test
<<<<<<< HEAD
    public void deveCadastrarUmVeterinario() {
=======
    public void testSave() {
       
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        Veterinario veterinario = new Veterinario();
        when(veterinarioRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(veterinarioRepository.save(veterinario)).thenReturn(veterinario);

<<<<<<< HEAD
=======
    
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        Veterinario result = veterinarioService.save(veterinario);

        assertEquals(veterinario, result);
    }

    @Test
<<<<<<< HEAD
    public void deveSalvarVeterinarioComIdExistente() {
=======
    public void testSaveWithExistingId() {
 
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        Veterinario veterinario = new Veterinario();
        veterinario.setId(1L);
        when(veterinarioRepository.findById(1L)).thenReturn(Optional.of(veterinario));

<<<<<<< HEAD
        assertThrows(VeterinarioJaExisteException.class, () -> veterinarioService.save(veterinario));
    }

    @Test
    public void deveAtualizarUmVeterinario() {
        Veterinario veterinario = new Veterinario();
        veterinario.getId();
        Veterinario veterinarioAtualizado = new Veterinario();
        veterinarioAtualizado.setNome("Raelzin");
        when(veterinarioRepository.findById(1L)).thenReturn(Optional.of(veterinario));
        when(veterinarioRepository.save(veterinarioAtualizado)).thenReturn(veterinarioAtualizado);

        Optional<Veterinario> result = veterinarioService.update(1L, veterinarioAtualizado);

        assertTrue(result.isPresent());
        assertEquals(veterinarioAtualizado.getNome(), result.get().getNome());
    }

    @Test
    public void deveDeletarUmVeterinario() {
        Veterinario veterinario = new Veterinario();
        veterinario.setId(1L);
        when(veterinarioRepository.findById(1L)).thenReturn(Optional.of(veterinario));

        veterinarioService.delete(1L);

        verify(veterinarioRepository).delete(veterinario);
    }

    @Test
    public void validaExcluirVeterinarioComIdInexistente() {
        when(veterinarioRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(VeterinarioJaExisteException.class, () -> veterinarioService.delete(1L));
=======
 
        assertThrows(VeterinarioJaExisteException.class, () -> veterinarioService.save(veterinario));
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
    }

    @Test
    public void testUpdate() {
     
        Veterinario veterinario = new Veterinario();
        veterinario.setId(1L);
        Veterinario veterinarioAtualizado = new Veterinario();
        veterinarioAtualizado.setNome("Novo Nome");
        when(veterinarioRepository.findById(1L)).thenReturn(Optional.of(veterinario));
        when(veterinarioRepository.save(veterinarioAtualizado)).thenReturn(veterinarioAtualizado);

 
        Optional<Veterinario> result = veterinarioService.update(1L, veterinarioAtualizado);

      
        assertTrue(result.isPresent());
        assertEquals(veterinarioAtualizado.getNome(), result.get().getNome());
    }

    @Test
    public void testDelete() {
      
        Veterinario veterinario = new Veterinario();
        veterinario.setId(1L);
        when(veterinarioRepository.findById(1L)).thenReturn(Optional.of(veterinario));

   
        veterinarioService.delete(1L);

        verify(veterinarioRepository).delete(veterinario);
    }

    @Test
    public void testDeleteNonexistentId() {
 
        when(veterinarioRepository.findById(1L)).thenReturn(Optional.empty());

  
        assertThrows(VeterinarioJaExisteException.class, () -> veterinarioService.delete(1L));
    }
}
