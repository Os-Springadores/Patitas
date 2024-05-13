package com.ada.patitas.projetopatitas.mapper;


import com.ada.patitas.projetopatitas.dto.VeterinarioDto;
import com.ada.patitas.projetopatitas.model.Veterinario;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class VeterinarioMapper {
    public static List<VeterinarioDto> toDto(final List<Veterinario> entities) {

        return entities.stream()
                .map(entity -> toDto(entity))
                .collect(Collectors.toList());
    }

    public static VeterinarioDto toDto(final Veterinario entity) {
        if (Objects.nonNull(entity)) {
            return VeterinarioDto.builder()
                    .nome(entity.getNome())
                    .especialidade(entity.getEspecialidade())
                    .horariosDisponiveis(entity.getHorariosDisponiveis())
                    .build();
        } else {
            return VeterinarioDto.builder().build();
        }
    }

    public static Veterinario toEntity(final VeterinarioDto dto) {
        return Veterinario.builder()
                .nome(dto.getNome())
                .especialidade(dto.getEspecialidade())
                .horariosDisponiveis(dto.getHorariosDisponiveis())
                .build();
    }

}
