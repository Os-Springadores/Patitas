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
import br.com.ada.patitas.model.HorariosDisponiveis;
import br.com.ada.patitas.repository.HorariosDisponiveisRepository;
import br.com.ada.patitas.serviceimpl.HorariosDisponiveisServiceImpl;

public class HorariosDisponiveisServiceImplTest {

    @Mock
    private HorariosDisponiveisRepository horariosDisponiveisRepository;

    @InjectMocks
    private HorariosDisponiveisServiceImpl horariosDisponiveisService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Given
        List<HorariosDisponiveis> horariosDisponiveis = new ArrayList<>();
        when(horariosDisponiveisRepository.findAll()).thenReturn(horariosDisponiveis);

        // When
        List<HorariosDisponiveis> result = horariosDisponiveisService.findAll();

        // Then
        assertEquals(horariosDisponiveis, result);
    }

    @Test
    public void testSave() {
        // Given
        HorariosDisponiveis horariosDisponiveis = new HorariosDisponiveis();
        when(horariosDisponiveisRepository.save(horariosDisponiveis)).thenReturn(horariosDisponiveis);

        // When
        HorariosDisponiveis result = horariosDisponiveisService.save(horariosDisponiveis);

        // Then
        assertEquals(horariosDisponiveis, result);
    }

    @Test
    public void testSaveWithExistingId() {
        // Given
        HorariosDisponiveis horariosDisponiveis = new HorariosDisponiveis();
        horariosDisponiveis.setId(1L);
        when(horariosDisponiveisRepository.findById(1L)).thenReturn(Optional.of(horariosDisponiveis));

        // When & Then
        assertThrows(ConsultaJaExisteException.class, () -> horariosDisponiveisService.save(horariosDisponiveis));
    }
}
