package br.com.ada.patitas.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

<<<<<<< HEAD
import br.com.ada.patitas.model.HorariosDisponiveis;
import br.com.ada.patitas.repository.HorariosDisponiveisRepository;

=======
import br.com.ada.patitas.exception.ConsultaJaExisteException;
import br.com.ada.patitas.model.HorariosDisponiveis;
import br.com.ada.patitas.repository.HorariosDisponiveisRepository;
import br.com.ada.patitas.serviceimpl.HorariosDisponiveisServiceImpl;
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee

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
<<<<<<< HEAD
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
=======
    public void testFindAll() {

        List<HorariosDisponiveis> horariosDisponiveis = new ArrayList<>();
        when(horariosDisponiveisRepository.findAll()).thenReturn(horariosDisponiveis);


        List<HorariosDisponiveis> result = horariosDisponiveisService.findAll();

        assertEquals(horariosDisponiveis, result);
    }

    @Test
    public void testSave() {
      
        HorariosDisponiveis horariosDisponiveis = new HorariosDisponiveis();
        when(horariosDisponiveisRepository.save(horariosDisponiveis)).thenReturn(horariosDisponiveis);

 
        HorariosDisponiveis result = horariosDisponiveisService.save(horariosDisponiveis);

  
        assertEquals(horariosDisponiveis, result);
    }

    @Test
    public void testSaveWithExistingId() {
   
        HorariosDisponiveis horariosDisponiveis = new HorariosDisponiveis();
        horariosDisponiveis.setId(1L);
        when(horariosDisponiveisRepository.findById(1L)).thenReturn(Optional.of(horariosDisponiveis));

       
        assertThrows(ConsultaJaExisteException.class, () -> horariosDisponiveisService.save(horariosDisponiveis));
    }
}
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
