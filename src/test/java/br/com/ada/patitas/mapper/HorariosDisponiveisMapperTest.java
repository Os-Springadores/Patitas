package br.com.ada.patitas.mapper;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import br.com.ada.patitas.dto.HorariosDisponiveisDto;
import br.com.ada.patitas.model.HorariosDisponiveis;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import org.junit.jupiter.api.Test;
import br.com.ada.patitas.dto.HorariosDisponiveisDto;
import br.com.ada.patitas.model.HorariosDisponiveis;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HorariosDisponiveisMapperTest {

    @Test
    public void testaToDtoHorariosDisponiveis() {
        HorariosDisponiveis horarios1 = new HorariosDisponiveis(1l,1l, LocalDateTime.of(2024,05,20,15,5),true);
        HorariosDisponiveis horarios2 = new HorariosDisponiveis(2L, 2l,LocalDateTime.of(2024,06,02,17,40), false);
=======
public class HorariosDisponiveisMapperTest {

    @Test
    public void testToDtoHorariosDisponiveis() {
       
        HorariosDisponiveis horarios1 = new HorariosDisponiveis(1L, "10:00", true);
        HorariosDisponiveis horarios2 = new HorariosDisponiveis(2L, "14:00", false);
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        List<HorariosDisponiveis> horariosDisponiveis = new ArrayList<>();
        horariosDisponiveis.add(horarios1);
        horariosDisponiveis.add(horarios2);

<<<<<<< HEAD
=======

>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        List<HorariosDisponiveisDto> horariosDto = HorariosDisponiveisMapper.toDtoHorariosDisponiveis(horariosDisponiveis);

        assertEquals(2, horariosDto.size());
        assertEquals(1L, horariosDto.get(0).getIdVeterinario());
<<<<<<< HEAD
        assertEquals(LocalDateTime.of(2024,05,20,15,5), horariosDto.get(0).getHorariosDisponiveis());
        assertTrue(horariosDto.get(0).isStatus());
        assertEquals(2L, horariosDto.get(1).getIdVeterinario());
        assertEquals(LocalDateTime.of(2024,06,02,17,40), horariosDto.get(1).getHorariosDisponiveis());
=======
        assertEquals("10:00", horariosDto.get(0).getHorariosDisponiveis());
        assertTrue(horariosDto.get(0).isStatus());
        assertEquals(2L, horariosDto.get(1).getIdVeterinario());
        assertEquals("14:00", horariosDto.get(1).getHorariosDisponiveis());
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        assertFalse(horariosDto.get(1).isStatus());
    }

    @Test
<<<<<<< HEAD
    public void testaToDtoHorariosDisponiveisDto() {
        HorariosDisponiveis horarios = new HorariosDisponiveis(1l,1l, LocalDateTime.of(2024,05,20,15,5),true);

        HorariosDisponiveisDto horariosDto = HorariosDisponiveisMapper.toDtoHorariosDisponiveis(horarios);

        assertNotNull(horariosDto);
        assertEquals(1L, horariosDto.getIdVeterinario());
        assertEquals(LocalDateTime.of(2024,05,20,15,5), horariosDto.getHorariosDisponiveis());
=======
    public void testToDtoHorariosDisponiveisDto() {
  
        HorariosDisponiveis horarios = new HorariosDisponiveis(1L, "10:00", true);

   
        HorariosDisponiveisDto horariosDto = HorariosDisponiveisMapper.toDtoHorariosDisponiveis(horarios);

    
        assertNotNull(horariosDto);
        assertEquals(1L, horariosDto.getIdVeterinario());
        assertEquals("10:00", horariosDto.getHorariosDisponiveis());
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        assertTrue(horariosDto.isStatus());
    }

    @Test
<<<<<<< HEAD
    public void testaToEntityHorariosDisponiveis() {
        HorariosDisponiveisDto horariosDto = new HorariosDisponiveisDto(1l,LocalDateTime.of(2024,05,20,15,5),true);

        HorariosDisponiveis horarios = HorariosDisponiveisMapper.toEntityHorariosDisponiveis(horariosDto);

        assertNotNull(horarios);
        assertEquals(1L, horarios.getIdVeterinario());
        assertEquals(LocalDateTime.of(2024,05,20,15,5), horarios.getHorariosDisponiveis());
=======
    public void testToEntityHorariosDisponiveis() {
   
        HorariosDisponiveisDto horariosDto = new HorariosDisponiveisDto(1L, "10:00", true);

   
        HorariosDisponiveis horarios = HorariosDisponiveisMapper.toEntityHorariosDisponiveis(horariosDto);

       
        assertNotNull(horarios);
        assertEquals(1L, horarios.getIdVeterinario());
        assertEquals("10:00", horarios.getHorariosDisponiveis());
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
        assertTrue(horarios.isStatus());
    }
}
