package br.com.ada.patitas.serviceimpl;

import static br.com.ada.patitas.DataConsulta.consulta;
import static br.com.ada.patitas.DataPaciente.listaPaciente;
import static br.com.ada.patitas.DataPaciente.paciente;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import br.com.ada.patitas.exception.PacienteJaExisteException;
import br.com.ada.patitas.model.Paciente;
import br.com.ada.patitas.repository.PacienteRepository;

public class PacienteServiceImplTest {


    private PacienteRepository pacienteRepository;

    private PacienteServiceImpl pacienteService;

    @BeforeEach
    public void preparar() {
        pacienteRepository = mock(PacienteRepository.class);
        pacienteService = new PacienteServiceImpl(pacienteRepository);
    }

    @Test
    public void deveListarPacientes() {
        List<Paciente> pacienteResposta = listaPaciente();
        when(pacienteRepository.findAll()).thenReturn(pacienteResposta);

        List<Paciente> pacientes = pacienteService.findAll();

        assertEquals(pacienteResposta, pacientes);
    }

    public static Stream<Arguments> gerarPacienteOptional() {
        return Stream.of(
                arguments(Optional.of(paciente())),
                arguments(Optional.empty())

        );
    }

    @ParameterizedTest
    @MethodSource("gerarPacienteOptional")
    void deveBuscarPacientePorId(Optional<Paciente> pacienteEsperado) {
        when(pacienteRepository.findById(1L)).thenReturn(pacienteEsperado);

        Optional<Paciente> pacienteOptional = pacienteService.findById(1L);

        assertEquals(pacienteEsperado, pacienteOptional);
        verify(pacienteRepository).findById(1L);
    }


    @Test
    public void deveCadastrarUmPaciente() {
        Paciente paciente = new Paciente();
        pacienteService.save(paciente);
        verify(pacienteRepository).save(paciente);
    }


    @Test
    public void deveSalvarPacienteComIdExistente() {

        Paciente paciente = new Paciente();
        paciente.setId(1L);
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));

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
        pacienteService.delete(1L);
        verify(pacienteRepository).deleteById(1L);
    }

    @Test
    public void validaExcluirPacienteComIdInexistente() {
        when(pacienteRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(PacienteJaExisteException.class, () -> pacienteService.delete(1L));


    }

}
