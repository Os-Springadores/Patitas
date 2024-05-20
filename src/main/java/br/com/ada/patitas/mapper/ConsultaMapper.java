package br.com.ada.patitas.mapper;

import br.com.ada.patitas.dto.ConsultaDto;
import br.com.ada.patitas.model.Consulta;
import br.com.ada.patitas.model.HorariosDisponiveis;
import br.com.ada.patitas.model.Paciente;
import br.com.ada.patitas.model.Veterinario;

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
                    .idVeterinario(consulta.getVeterinario().getId())
                    .idPaciente(consulta.getPaciente().getId())
                    .idHorariosDisponiveis(consulta.getHorariosDisponiveis().getId())
                    .servico(consulta.getServico())
                    .tipoServico(consulta.getTipoServico())
                    .preco(consulta.getPreco())
                    .status(consulta.isStatus())
                    .build();
        }
        return null;
    }


    public static Consulta toEntityConsulta(final ConsultaDto consultaDto) {
        Veterinario veterinario = Veterinario.builder().id(consultaDto.getIdVeterinario()).build();
        Paciente paciente=Paciente.builder().id(consultaDto.getIdPaciente()).build();
        HorariosDisponiveis horariosDisponiveis=HorariosDisponiveis.builder().id(consultaDto.getIdHorariosDisponiveis()).build();
        return Consulta.builder()
                .veterinario(veterinario)
                .paciente(paciente)
                .horariosDisponiveis(horariosDisponiveis)
                .servico(consultaDto.getServico())
                .tipoServico(consultaDto.getTipoServico())
                .preco(consultaDto.getPreco())
                .status(consultaDto.isStatus())
                .build();
    }
}
