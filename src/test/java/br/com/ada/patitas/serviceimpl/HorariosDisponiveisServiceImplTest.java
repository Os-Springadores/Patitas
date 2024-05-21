package br.com.ada.patitas.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.ada.patitas.model.HorariosDisponiveis;
import br.com.ada.patitas.repository.HorariosDisponiveisRepository;


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
    public void deveListarHorariosDisponiveis() {
        List<HorariosDisponiveis> horariosDisponiveis = new ArrayList<>();
        when(horariosDisponiveisRepository.findAll()).thenReturn(horariosDisponiveis);

        List<HorariosDisponiveis> horariosDisponiveisList = horariosDisponiveisService.findAll();


        assertEquals(horariosDisponiveis, horariosDisponiveisList);
    }

    @Test
    public void deveCadastrarUmHorario() {
        HorariosDisponiveis horariosDisponiveis = new HorariosDisponiveis();
        when(horariosDisponiveisRepository.save(horariosDisponiveis)).thenReturn(horariosDisponiveis);

        HorariosDisponiveis horariosDisponiveisList = horariosDisponiveisService.save(horariosDisponiveis);

        assertEquals(horariosDisponiveis, horariosDisponiveisList);
    }

}