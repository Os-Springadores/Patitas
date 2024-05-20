package br.com.ada.patitas.mapper;

import br.com.ada.patitas.dto.ConsultaDto;
import br.com.ada.patitas.model.Consulta;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConsultaMapper {

    public static List<ConsultaDto> toDtoConsulta(final List<Consulta> consultas) {
        return consultas.stream()
                .map(entity -> toDtoConsultaDto(entity))
                .collect(Collectors.toList());
    }

    public static ConsultaDto toDtoConsultaDto(final Consulta consulta) {
        if (Objects.nonNull(consulta)) {
            return ConsultaDto.builder()
                    .idVeterinario(consulta.getIdVeterinario())
                    .idPaciente(consulta.getIdPaciente())
                    .idHorariosDisponiveis(consulta.getIdHorariosDisponiveis())
                    .motivoDaConsulta(consulta.getMotivoDaConsulta())
                    .build();
        }
        return null;
    }


    public static Consulta toEntityConsulta(final ConsultaDto consultaDto) {
        return Consulta.builder()
                .idVeterinario(consultaDto.getIdVeterinario())
                .idPaciente(consultaDto.getIdPaciente())
                .idHorariosDisponiveis(consultaDto.getIdHorariosDisponiveis())
                .motivoDaConsulta(consultaDto.getMotivoDaConsulta())
                .build();
    }
}
