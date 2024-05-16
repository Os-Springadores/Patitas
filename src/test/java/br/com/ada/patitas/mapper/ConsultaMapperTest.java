package br.com.ada.patitas.mapper;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import br.com.ada.patitas.dto.ConsultaDto;
import br.com.ada.patitas.model.Consulta;
import java.util.ArrayList;
import java.util.List;

public class ConsultaMapperTest {

    @Test
    public void testToDtoConsulta() {
        Consulta consulta1 = new Consulta(1L, 1L, 1L);
        Consulta consulta2 = new Consulta(2L, 2L, 2L);
        List<Consulta> consultas = new ArrayList<>();
        consultas.add(consulta1);
        consultas.add(consulta2);

        List<ConsultaDto> consultaDtos = ConsultaMapper.toDtoConsulta(consultas);

        assertEquals(2, consultaDtos.size());
        assertEquals(1L, consultaDtos.get(0).getIdVeterinario());
        assertEquals(1L, consultaDtos.get(0).getIdPaciente());
        assertEquals(1L, consultaDtos.get(0).getIdHorariosDisponiveis());
        assertEquals(2L, consultaDtos.get(1).getIdVeterinario());
        assertEquals(2L, consultaDtos.get(1).getIdPaciente());
        assertEquals(2L, consultaDtos.get(1).getIdHorariosDisponiveis());
    }

    @Test
    public void testToDtoConsultaDto() {
        Consulta consulta = new Consulta(1L, 1L, 1L);

        ConsultaDto consultaDto = ConsultaMapper.toDtoConsultaDto(consulta);

        assertNotNull(consultaDto);
        assertEquals(1L, consultaDto.getIdVeterinario());
        assertEquals(1L, consultaDto.getIdPaciente());
        assertEquals(1L, consultaDto.getIdHorariosDisponiveis());
    }

    @Test
    public void testToEntityConsulta() {
        ConsultaDto consultaDto = new ConsultaDto(1L, 1L, 1L);

        Consulta consulta = ConsultaMapper.toEntityConsulta(consultaDto);

        assertNotNull(consulta);
        assertEquals(1L, consulta.getIdVeterinario());
        assertEquals(1L, consulta.getIdPaciente());
        assertEquals(1L, consulta.getIdHorariosDisponiveis());
    }
}