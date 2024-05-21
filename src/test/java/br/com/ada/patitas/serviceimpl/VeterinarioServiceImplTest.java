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
    public void deveListarTodosPacientes() {
        List<Veterinario> veterinarios = new ArrayList<>();
        when(veterinarioRepository.findAll()).thenReturn(veterinarios);

        List<Veterinario> result = veterinarioService.findAll();
 
        assertEquals(veterinarios, result);
    }

    @Test
    public void deveProcurarVeterinarioPorId() {
        Veterinario veterinario = new Veterinario();
        veterinario.setId(1L);
        when(veterinarioRepository.findById(1L)).thenReturn(Optional.of(veterinario));

        Optional<Veterinario> result = veterinarioService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(veterinario, result.get());
    }

    @Test
    public void deveCadastrarUmVeterinario() {
        Veterinario veterinario = new Veterinario();
        when(veterinarioRepository.findById(anyLong())).thenReturn(Optional.empty());
        when(veterinarioRepository.save(veterinario)).thenReturn(veterinario);
        Veterinario result = veterinarioService.save(veterinario);

        assertEquals(veterinario, result);
    }

    @Test
    public void deveSalvarVeterinarioComIdExistente() {
 Veterinario veterinario = new Veterinario();
        veterinario.setId(1L);
        when(veterinarioRepository.findById(1L)).thenReturn(Optional.of(veterinario));

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
