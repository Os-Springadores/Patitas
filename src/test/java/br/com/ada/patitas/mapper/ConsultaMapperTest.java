package br.com.ada.patitas.mapper;

import static org.junit.jupiter.api.Assertions.*;

import br.com.ada.patitas.model.Servico;
import org.junit.jupiter.api.Test;
import br.com.ada.patitas.dto.ConsultaDto;
import br.com.ada.patitas.model.Consulta;
import java.util.ArrayList;
import java.util.List;


public class ConsultaMapperTest {

    @Test
    public void testaToDtoConsulta() {
        Consulta consulta1 = new Consulta(1l, null, null,null, Servico.CIRURGIA,"Castração",250.0,true);
        Consulta consulta2 = new Consulta(2L, null, null,null,Servico.ATENDIMENTO_CLINICO,"Consulta",150.0,true);


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
    public void testaToDtoConsultaDto() {
        Consulta consulta = new Consulta(1l, null, null,null, Servico.CIRURGIA,"Castração",250.0,true);

        ConsultaDto consultaDto = ConsultaMapper.toDtoConsultaDto(consulta);

        assertNotNull(consultaDto);
        assertEquals(null, consultaDto.getIdVeterinario());
        assertEquals(null, consultaDto.getIdPaciente());
        assertEquals(null, consultaDto.getIdHorariosDisponiveis());
    }

    @Test
    public void testaToEntityConsulta() {
        ConsultaDto consultaDto = new ConsultaDto( null, null,null, Servico.CIRURGIA,"Castração",250.0,true);
        assertEquals(1L, consultaDto.getIdVeterinario());
        assertEquals(1L, consultaDto.getIdPaciente());
        assertEquals(1L, consultaDto.getIdHorariosDisponiveis());


    }
}
