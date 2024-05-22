package br.com.ada.patitas.mapper;

import static org.junit.jupiter.api.Assertions.*;

import br.com.ada.patitas.DataHorariosDisponiveis;
import br.com.ada.patitas.model.Especialidade;
import br.com.ada.patitas.model.Veterinario;
import org.junit.jupiter.api.Test;
import br.com.ada.patitas.dto.HorariosDisponiveisDto;
import br.com.ada.patitas.model.HorariosDisponiveis;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HorariosDisponiveisMapperTest {

    @Test
    public void testToDtoHorariosDisponiveis() {
        Veterinario veterinario = new Veterinario(1L, "Eber", Especialidade.DERMATOLOGIA);

        HorariosDisponiveis horarios1 = new HorariosDisponiveis(1l, null, LocalDateTime.of(2024, 05, 20, 15, 5), true);
        HorariosDisponiveis horarios2 = new HorariosDisponiveis(2L, veterinario, LocalDateTime.of(2024, 06, 02, 17, 40), false);
        List<HorariosDisponiveis> horariosDisponiveis = DataHorariosDisponiveis.listaHorariosDisponiveis();
        horariosDisponiveis.add(horarios1);
        horariosDisponiveis.add(horarios2);


        assertEquals(2, horariosDisponiveis.size());
        assertEquals(1L, horariosDisponiveis.get(0).getVeterinario());
        assertEquals(LocalDateTime.of(2024, 05, 20, 15, 5), horariosDisponiveis.get(0).getHorariosDisponiveis());
        assertTrue(horariosDisponiveis.get(0).isStatus());
        assertEquals(2L, horariosDisponiveis.get(1).getVeterinario());
        assertEquals(LocalDateTime.of(2024, 06, 02, 17, 40), horariosDisponiveis.get(1).getHorariosDisponiveis());
        assertFalse(horariosDisponiveis.get(1).isStatus());
    }

    @Test
    public void testToDtoHorariosDisponiveisDto() {
        HorariosDisponiveis horarios = new HorariosDisponiveis(1L, null, LocalDateTime.of(2024, 05, 20, 15, 5), true);

        HorariosDisponiveisDto horariosDto = HorariosDisponiveisMapper.toDtoHorariosDisponiveis(horarios);

        assertNotNull(horariosDto);
        assertEquals(1L, horariosDto.getIdVeterinario());
        assertEquals(LocalDateTime.of(2024, 05, 20, 15, 5), horariosDto.getHorariosDisponiveis());
        assertTrue(horariosDto.isStatus());
    }

    @Test
    public void testToEntityHorariosDisponiveis() {
        HorariosDisponiveisDto horariosDto = new HorariosDisponiveisDto(1l, LocalDateTime.of(2024, 05, 20, 15, 5), true);

        HorariosDisponiveis horarios = HorariosDisponiveisMapper.toEntityHorariosDisponiveis(horariosDto);

        assertNotNull(horarios);
        assertEquals(1L, horarios.getVeterinario());
        assertEquals(LocalDateTime.of(2024, 05, 20, 15, 5), horarios.getHorariosDisponiveis());
        assertTrue(horarios.isStatus());
    }
}