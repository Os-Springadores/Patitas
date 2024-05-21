package br.com.ada.patitas.mapper;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import br.com.ada.patitas.dto.ConsultaDto;
import br.com.ada.patitas.model.Consulta;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
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
=======
public class ConsultaMapperTest {

    @Test
    public void testToDtoConsulta() {
        Consulta consulta1 = new Consulta(1L, 1L, 1L);
        Consulta consulta2 = new Consulta(2L, 2L, 2L);
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
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
<<<<<<< HEAD
    public void testaToDtoConsultaDto() {
        Consulta consulta = new Consulta(1l, null, null,null, Servico.CIRURGIA,"Castração",250.0,true);
=======
    public void testToDtoConsultaDto() {
        // Given
        Consulta consulta = new Consulta(1L, 1L, 1L);
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee

        ConsultaDto consultaDto = ConsultaMapper.toDtoConsultaDto(consulta);

        assertNotNull(consultaDto);
<<<<<<< HEAD
        assertEquals(null, consultaDto.getIdVeterinario());
        assertEquals(null, consultaDto.getIdPaciente());
        assertEquals(null, consultaDto.getIdHorariosDisponiveis());
    }

    @Test
    public void testaToEntityConsulta() {
        ConsultaDto consultaDto = new ConsultaDto( null, null,null, Servico.CIRURGIA,"Castração",250.0,true);
=======
        assertEquals(1L, consultaDto.getIdVeterinario());
        assertEquals(1L, consultaDto.getIdPaciente());
        assertEquals(1L, consultaDto.getIdHorariosDisponiveis());
    }

    @Test
    public void testToEntityConsulta() {
        ConsultaDto consultaDto = new ConsultaDto(1L, 1L, 1L);
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee

        Consulta consulta = ConsultaMapper.toEntityConsulta(consultaDto);

        assertNotNull(consulta);
<<<<<<< HEAD
        assertEquals(null, consulta.getId());
        assertEquals(null, consulta.getPaciente().getId());
        assertEquals(null, consulta.getVeterinario().getId());
=======
        assertEquals(1L, consulta.getIdVeterinario());
        assertEquals(1L, consulta.getIdPaciente());
        assertEquals(1L, consulta.getIdHorariosDisponiveis());
>>>>>>> 951050a5916b37fa67d563f5fa9a8c4edf53b6ee
    }
}
