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

    @Test
    public void testaConsultaPorId() {
        Consulta consulta = new Consulta();
        consulta.setId(1L);
        when(consultaRepository.findById(1L)).thenReturn(Optional.of(consulta));

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
    public void testaAtualizaçãoDeConsulta() {
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
    }

    @Test
    public void testaDeletarConsulta() {
        Consulta consulta = new Consulta();
        consulta.setId(1L);
        when(consultaRepository.findById(1L)).thenReturn(Optional.of(consulta));

        consultaService.delete(1L);

        verify(consultaRepository).delete(consulta);
    }
}