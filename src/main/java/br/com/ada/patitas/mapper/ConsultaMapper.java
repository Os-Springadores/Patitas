package br.com.ada.patitas.mapper;

import br.com.ada.patitas.dto.ConsultaDto;
import br.com.ada.patitas.model.Consulta;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConsultaMapper {

    public static List<ConsultaDto> toDtoConsulta(final List<Consulta> consultas) {
        return consultas.stream()
                .map(ConsultaMapper::toDtoConsultaDto)
                .collect(Collectors.toList());
    }

    public static ConsultaDto toDtoConsultaDto(final Consulta consulta) {
        if (Objects.nonNull(consulta)) {
            return ConsultaDto.builder()
                    .veterinario(consulta.getVeterinario())
                    .paciente(consulta.getPaciente())
                    .data(consulta.getData())
                    .hora(consulta.getHora())
                    .build();
        }
        return ConsultaDto.builder().build();
    }


    public static Consulta toEntityConsulta(final ConsultaDto consultaDto){
        return Consulta.builder()
                .veterinario(consultaDto.getVeterinario())
                .paciente(consultaDto.getPaciente())
                .data(consultaDto.getData())
                .hora(consultaDto.getHora())
                .build();
    }
}
