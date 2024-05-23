package br.com.ada.patitas.mapper;

import br.com.ada.patitas.dto.HorariosDisponiveisDto;
import br.com.ada.patitas.model.HorariosDisponiveis;
import br.com.ada.patitas.model.Veterinario;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HorariosDisponiveisMapper {
    public static List<HorariosDisponiveisDto> toDtoHorariosDisponiveis(final List<HorariosDisponiveis> horariosDisponiveis) {
        return horariosDisponiveis.stream()
                .map(entity -> toDtoHorariosDisponiveis(entity))
                .collect(Collectors.toList());
    }

    public static HorariosDisponiveisDto toDtoHorariosDisponiveis(final HorariosDisponiveis horariosDisponiveis) {
        if (Objects.nonNull(horariosDisponiveis)) {
            return HorariosDisponiveisDto.builder()
                    .idVeterinario(horariosDisponiveis.getVeterinario().getId())
                    .horariosDisponiveis(horariosDisponiveis.getHorariosDisponiveis())
                    .status(horariosDisponiveis.isStatus())
                    .build();

        }
        return null;
    }

    public static HorariosDisponiveis toEntityHorariosDisponiveis(final HorariosDisponiveisDto horariosDisponiveisDto) {
        Veterinario veterinario = Veterinario.builder().id(horariosDisponiveisDto.getIdVeterinario()).build();

        return HorariosDisponiveis.builder()
                .veterinario(veterinario)
                .horariosDisponiveis(horariosDisponiveisDto.getHorariosDisponiveis())
                .status(horariosDisponiveisDto.isStatus())
                .build();
    }

}
