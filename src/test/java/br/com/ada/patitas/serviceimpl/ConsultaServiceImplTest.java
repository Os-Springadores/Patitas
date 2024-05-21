package br.com.ada.patitas.serviceimpl;

import static br.com.ada.patitas.DataConsulta.consulta;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import br.com.ada.patitas.model.HorariosDisponiveis;
import br.com.ada.patitas.model.Paciente;
import br.com.ada.patitas.model.Veterinario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.ada.patitas.model.Consulta;
import br.com.ada.patitas.repository.ConsultaRepository;

public class ConsultaServiceImplTest {

    @Mock
    private ConsultaRepository consultaRepository;

    @InjectMocks
    private ConsultaServiceImpl consultaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testaListaDeConsultas() {
        List<Consulta> consultas = new ArrayList<>();

        when(consultaRepository.findAll()).thenReturn(consultas);

        List<Consulta> consulta = consultaService.findAll();

        assertEquals(consultas, consulta);
    }

    public static Stream<Arguments> gerarConsultaOptional() {
        return Stream.of(
                arguments(Optional.of(consulta())),
                arguments(Optional.empty())

        );
    }

    @Test
    public void testaConsultaPorId() {
    
        List<Consulta> consultas = new ArrayList<>();
        when(consultaRepository.findAll()).thenReturn(consultas);

 
        List<Consulta> result = consultaService.findAll();

       
        assertEquals(consultas, result);
    }


    @Test
    public void testaCadastroDeConsulta() {
        Consulta consulta = new Consulta();
        when(consultaRepository.save(consulta)).thenReturn(consulta);


        Consulta consulta1 = consultaService.save(consulta);

        assertEquals(consulta, consulta1);
    }
//Refazer esse teste
//    @Test
//    public void testaAtualizaçãoDeConsulta() {
//        Veterinario veterinario = Veterinario.builder().id(consultaAtualizado.getVeterinario().getId()).build();
//        Paciente paciente = Paciente.builder().id(consultaAtualizado.getPaciente().getId()).build();
//        HorariosDisponiveis horariosDisponiveis = HorariosDisponiveis.builder().id(consultaAtualizado.getHorariosDisponiveis().getId()).build();
//
//        Consulta consulta = new Consulta();
//        consulta.getId();
//        consultaAtualizado.setVeterinario(veterinario);
//        consultaAtualizado.setPaciente(paciente);
//        consultaAtualizado.setHorariosDisponiveis(horariosDisponiveis);
//        when(consultaRepository.findById(1L)).thenReturn(Optional.of(consulta));
//        when(consultaRepository.save(consulta)).thenReturn(consulta);
//
//        Optional<Consulta> result = consultaService.update(1L, consultaAtualizado);
//
//        assertTrue(result.isPresent());
//        assertEquals(consultaAtualizado.getVeterinario(), result.get().getVeterinario());
//        assertEquals(consultaAtualizado.getPaciente(), result.get().getPaciente());
//        assertEquals(consultaAtualizado.getHorariosDisponiveis(), result.get().getHorariosDisponiveis());
//    }

    @Test
    public void testaDeletarConsulta() {
        Consulta consulta = new Consulta();
        consulta.setId(1L);
        when(consultaRepository.findById(1L)).thenReturn(Optional.of(consulta));

        consultaService.delete(1L);

        verify(consultaRepository).delete(consulta);

        Optional<Consulta> result = consultaService.findById(1L);

   
        assertTrue(result.isPresent());
        assertEquals(consulta, result.get());
    }

}
