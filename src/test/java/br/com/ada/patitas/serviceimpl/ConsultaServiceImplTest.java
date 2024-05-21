package br.com.ada.patitas.serviceimpl;

<<<<<<< HEAD
import static br.com.ada.patitas.DataConsulta.consulta;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
=======
import static org.junit.jupiter.api.Assertions.*;
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
<<<<<<< HEAD
import java.util.stream.Stream;

import br.com.ada.patitas.model.HorariosDisponiveis;
import br.com.ada.patitas.model.Paciente;
import br.com.ada.patitas.model.Veterinario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
=======

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

<<<<<<< HEAD
import br.com.ada.patitas.model.Consulta;
import br.com.ada.patitas.repository.ConsultaRepository;
=======
import br.com.ada.patitas.exception.ConsultaJaExisteException;
import br.com.ada.patitas.model.Consulta;
import br.com.ada.patitas.repository.ConsultaRepository;
import br.com.ada.patitas.serviceimpl.ConsultaServiceImpl;
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee

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
<<<<<<< HEAD
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
=======
    public void testFindAll() {
    
        List<Consulta> consultas = new ArrayList<>();
        when(consultaRepository.findAll()).thenReturn(consultas);

 
        List<Consulta> result = consultaService.findAll();

       
        assertEquals(consultas, result);
    }

    @Test
    public void testFindById() {
 
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        Consulta consulta = new Consulta();
        consulta.setId(1L);
        when(consultaRepository.findById(1L)).thenReturn(Optional.of(consulta));

<<<<<<< HEAD
        Optional<Consulta> consultaOptional = consultaService.findById(1L);

        assertTrue(consultaOptional.isPresent());
        assertEquals(consulta, consultaOptional.get());
    }

    @Test
    public void testaCadastroDeConsulta() {
        Consulta consulta = new Consulta();
        when(consultaRepository.save(consulta)).thenReturn(consulta);


        Consulta consulta1 = consultaService.save(consulta);

        assertEquals(consulta, consulta1);
    }

    @Test
    public void testaAtualizaçãoDeConsulta(Long id, Consulta consultaAtualizado) {
        Veterinario veterinario = Veterinario.builder().id(consultaAtualizado.getVeterinario().getId()).build();
        Paciente paciente = Paciente.builder().id(consultaAtualizado.getPaciente().getId()).build();
        HorariosDisponiveis horariosDisponiveis = HorariosDisponiveis.builder().id(consultaAtualizado.getHorariosDisponiveis().getId()).build();

        Consulta consulta = new Consulta();
        consulta.getId();
        consultaAtualizado.setVeterinario(veterinario);
        consultaAtualizado.setPaciente(paciente);
        consultaAtualizado.setHorariosDisponiveis(horariosDisponiveis);
        when(consultaRepository.findById(1L)).thenReturn(Optional.of(consulta));
        when(consultaRepository.save(consulta)).thenReturn(consulta);

        Optional<Consulta> result = consultaService.update(1L, consultaAtualizado);

        assertTrue(result.isPresent());
        assertEquals(consultaAtualizado.getVeterinario(), result.get().getVeterinario());
        assertEquals(consultaAtualizado.getPaciente(), result.get().getPaciente());
        assertEquals(consultaAtualizado.getHorariosDisponiveis(), result.get().getHorariosDisponiveis());
    }

    @Test
    public void testaDeletarConsulta() {
        Consulta consulta = new Consulta();
        consulta.setId(1L);
        when(consultaRepository.findById(1L)).thenReturn(Optional.of(consulta));

        consultaService.delete(1L);

        verify(consultaRepository).delete(consulta);
=======
    
        Optional<Consulta> result = consultaService.findById(1L);

   
        assertTrue(result.isPresent());
        assertEquals(consulta, result.get());
    }

    @Test
    public void testSave() {

        Consulta consulta = new Consulta();
        when(consultaRepository.save(consulta)).thenReturn(consulta);

    
        Consulta result = consultaService.save(consulta);


        assertEquals(consulta, result);
    }

    @Test
    public void testUpdate() {
   
        Consulta consulta = new Consulta();
        consulta.setId(1L);
        Consulta consultaAtualizado = new Consulta();
        consultaAtualizado.setIdVeterinario(2L);
        consultaAtualizado.setIdPaciente(3L);
        consultaAtualizado.setIdHorariosDisponiveis(4L);
        when(consultaRepository.findById(1L)).thenReturn(Optional.of(consulta));
        when(consultaRepository.save(consulta)).thenReturn(consulta);

      
        Optional<Consulta> result = consultaService.update(1L, consultaAtualizado);

    
        assertTrue(result.isPresent());
        assertEquals(consultaAtualizado.getIdVeterinario(), result.get().getIdVeterinario());
        assertEquals(consultaAtualizado.getIdPaciente(), result.get().getIdPaciente());
        assertEquals(consultaAtualizado.getIdHorariosDisponiveis(), result.get().getIdHorariosDisponiveis());
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
    }

    @Test
    public void testDelete() {
     
        Consulta consulta = new Consulta();
        consulta.setId(1L);
        when(consultaRepository.findById(1L)).thenReturn(Optional.of(consulta));

        consultaService.delete(1L);

    
        verify(consultaRepository).delete(consulta);
    }
}
