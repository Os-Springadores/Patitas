package br.com.ada.patitas.serviceimpl;

import static br.com.ada.patitas.DataConsulta.consulta;
import static br.com.ada.patitas.DataConsulta.listaDeConsultas;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import br.com.ada.patitas.model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import org.junit.jupiter.params.provider.MethodSource;


import org.mockito.Mockito;


import br.com.ada.patitas.repository.ConsultaRepository;

public class ConsultaServiceImplTest {


    private ConsultaRepository consultaRepository;

    private ConsultaServiceImpl consultaService;

    @BeforeEach
    public void preparar() {
        consultaRepository = Mockito.mock(ConsultaRepository.class);
        consultaService = new ConsultaServiceImpl(consultaRepository);
    }

    @Test
    public void testaListaDeConsultas() {
        List<Consulta> consultasEsperadas = listaDeConsultas();

        when(consultaRepository.findAll()).thenReturn(consultasEsperadas);

        List<Consulta> consultas = consultaService.findAll();

        assertEquals(consultasEsperadas, consultas);
    }

    public static Stream<Arguments> gerarConsultaOptional() {
        return Stream.of(
                arguments(Optional.of(consulta())),
                arguments(Optional.empty())

        );
    }

    @ParameterizedTest
    @MethodSource("gerarConsultaOptional")
    void deveBusarConsultaPorId(Optional<Consulta> consultaEsperado) {
        when(consultaRepository.findById(1L)).thenReturn(consultaEsperado);

        Optional<Consulta> consultaOptional = consultaService.findById(1L);

        assertEquals(consultaEsperado, consultaOptional);
        verify(consultaRepository).findById(1L);
    }



    @Test
    public void testaCadastroDeConsulta() {
        Consulta consulta = new Consulta();
        consultaService.save(consulta);
        verify(consultaRepository).save(consulta);
    }


    @Test
    public void testaDeletarConsulta() {
        consultaService.delete(1L);
        verify(consultaRepository).deleteById(1L);
    }

}
