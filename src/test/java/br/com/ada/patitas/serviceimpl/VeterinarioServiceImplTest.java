package br.com.ada.patitas.serviceimpl;


import static br.com.ada.patitas.DataVeterinario.listaVeterinario;
import static br.com.ada.patitas.DataVeterinario.veterinario;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.ada.patitas.exception.VeterinarioJaExisteException;
import br.com.ada.patitas.model.Veterinario;
import br.com.ada.patitas.repository.VeterinarioRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class VeterinarioServiceImplTest {


    private VeterinarioRepository veterinarioRepository;


    private VeterinarioServiceImpl veterinarioService;

    @BeforeEach
    public void preparar() {
        veterinarioRepository = mock(VeterinarioRepository.class);
        veterinarioService = new VeterinarioServiceImpl(veterinarioRepository);
    }

    @Test
    public void deveListarVeterinarios() {
        List<Veterinario> veterinarioResposta = listaVeterinario();
        when(veterinarioRepository.findAll()).thenReturn(veterinarioResposta);

        List<Veterinario> veterinarios = veterinarioService.findAll();

        assertEquals(veterinarioResposta, veterinarios);
    }

    public static Stream<Arguments> gerarVeterinarioOptional() {
        return Stream.of(
                arguments(Optional.of(veterinario())),
                arguments(Optional.empty())

        );
    }

    @ParameterizedTest
    @MethodSource("gerarVeterinarioOptional")
    void deveBuscarVeterinarioPorId(Optional<Veterinario> veterinarioEsperado) {
        when(veterinarioRepository.findById(1L)).thenReturn(veterinarioEsperado);

        Optional<Veterinario> veterinarioOptional = veterinarioService.findById(1L);

        assertEquals(veterinarioEsperado, veterinarioOptional);
        verify(veterinarioRepository).findById(1L);
    }

    @Test
    public void deveCadastrarUmVeterinario() {
        Veterinario veterinario = new Veterinario();
        veterinarioService.save(veterinario);
        verify(veterinarioRepository).save(veterinario);
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
        veterinarioAtualizado.setNome("Bernardo");
        when(veterinarioRepository.findById(1L)).thenReturn(Optional.of(veterinario));
        when(veterinarioRepository.save(veterinarioAtualizado)).thenReturn(veterinarioAtualizado);

        Optional<Veterinario> result = veterinarioService.update(1L, veterinarioAtualizado);

        assertTrue(result.isPresent());
        assertEquals(veterinarioAtualizado.getNome(), result.get().getNome());
    }

    @Test
    public void deveDeletarUmVeterinario() {
        veterinarioService.delete(1L);
        verify(veterinarioRepository).deleteById(1L);
    }

    @Test
    public void validaExcluirVeterinarioComIdInexistente() {
        when(veterinarioRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(VeterinarioJaExisteException.class, () -> veterinarioService.delete(1L));
    }


}
