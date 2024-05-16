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

import br.com.ada.patitas.exception.ConsultaJaExisteException;
import br.com.ada.patitas.model.Consulta;
import br.com.ada.patitas.repository.ConsultaRepository;
import br.com.ada.patitas.serviceimpl.ConsultaServiceImpl;

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
    public void testFindAll() {
        // Given
        List<Consulta> consultas = new ArrayList<>();
        when(consultaRepository.findAll()).thenReturn(consultas);

        // When
        List<Consulta> result = consultaService.findAll();

        // Then
        assertEquals(consultas, result);
    }

    @Test
    public void testFindById() {
        // Given
        Consulta consulta = new Consulta();
        consulta.setId(1L);
        when(consultaRepository.findById(1L)).thenReturn(Optional.of(consulta));

        // When
        Optional<Consulta> result = consultaService.findById(1L);

        // Then
        assertTrue(result.isPresent());
        assertEquals(consulta, result.get());
    }

    @Test
    public void testSave() {
        // Given
        Consulta consulta = new Consulta();
        when(consultaRepository.save(consulta)).thenReturn(consulta);

        // When
        Consulta result = consultaService.save(consulta);

        // Then
        assertEquals(consulta, result);
    }

    @Test
    public void testUpdate() {
        // Given
        Consulta consulta = new Consulta();
        consulta.setId(1L);
        Consulta consultaAtualizado = new Consulta();
        consultaAtualizado.setIdVeterinario(2L);
        consultaAtualizado.setIdPaciente(3L);
        consultaAtualizado.setIdHorariosDisponiveis(4L);
        when(consultaRepository.findById(1L)).thenReturn(Optional.of(consulta));
        when(consultaRepository.save(consulta)).thenReturn(consulta);

        // When
        Optional<Consulta> result = consultaService.update(1L, consultaAtualizado);

        // Then
        assertTrue(result.isPresent());
        assertEquals(consultaAtualizado.getIdVeterinario(), result.get().getIdVeterinario());
        assertEquals(consultaAtualizado.getIdPaciente(), result.get().getIdPaciente());
        assertEquals(consultaAtualizado.getIdHorariosDisponiveis(), result.get().getIdHorariosDisponiveis());
    }

    @Test
    public void testDelete() {
        // Given
        Consulta consulta = new Consulta();
        consulta.setId(1L);
        when(consultaRepository.findById(1L)).thenReturn(Optional.of(consulta));

        // When
        consultaService.delete(1L);

        // Then
        verify(consultaRepository).delete(consulta);
    }
}
