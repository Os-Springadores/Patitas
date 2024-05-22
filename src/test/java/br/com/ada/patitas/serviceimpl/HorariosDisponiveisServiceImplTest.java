package br.com.ada.patitas.serviceimpl;

import static br.com.ada.patitas.DataHorariosDisponiveis.listaHorariosDisponiveis;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import br.com.ada.patitas.model.HorariosDisponiveis;
import br.com.ada.patitas.repository.HorariosDisponiveisRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;


public class HorariosDisponiveisServiceImplTest {


    private HorariosDisponiveisRepository horariosDisponiveisRepository;

    private HorariosDisponiveisServiceImpl horariosDisponiveisService;

    @BeforeEach
    public void preparar() {
        horariosDisponiveisRepository= mock(HorariosDisponiveisRepository.class);
        horariosDisponiveisService= new HorariosDisponiveisServiceImpl(horariosDisponiveisRepository);
    }

    @Test
    public void deveListarHorariosDisponiveis() {
        List<HorariosDisponiveis> horariosDisponiveis = listaHorariosDisponiveis();
        when(horariosDisponiveisRepository.findAll()).thenReturn(horariosDisponiveis);

        List<HorariosDisponiveis> horariosDisponiveisList = horariosDisponiveisService.findAll();


        assertEquals(horariosDisponiveis, horariosDisponiveisList);
    }

    @Test
    public void deveCadastrarUmHorario() {
        HorariosDisponiveis horariosDisponiveis = new HorariosDisponiveis();
       horariosDisponiveisService.save(horariosDisponiveis);
       verify(horariosDisponiveisRepository).save(horariosDisponiveis);
    }

}


