package br.com.ada.patitas.mapper;

import br.com.ada.patitas.dto.PacienteDto;
import br.com.ada.patitas.model.Paciente;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PacienteMapper {
    public static List<PacienteDto> toDtoPaciente(final List<Paciente> entities) {

        return entities.stream()
                .map(entity -> toDtoPaciente(entity))
                .collect(Collectors.toList());
    }

    public static PacienteDto toDtoPaciente(final Paciente entity) {
        if (Objects.nonNull(entity)) {
            return PacienteDto.builder()
                    .id(entity.getId())
                    .nome(entity.getNome())
                    .especie(entity.getEspecie())
                    .raca(entity.getRaca())
                    .idade(entity.getIdade())
                    .peso(entity.getPeso())
                    .build();
        } else {
            return PacienteDto.builder().build();
        }
    }

    public static Paciente toEntityPaciente(final PacienteDto dto) {
        return Paciente.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .especie(dto.getEspecie())
                .raca(dto.getRaca())
                .idade(dto.getIdade())
                .peso(dto.getPeso())
                .build();
    }
}
