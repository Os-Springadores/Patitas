package br.com.ada.patitas.mapper;

import br.com.ada.patitas.dto.HorariosDisponiveisDto;
import br.com.ada.patitas.model.HorariosDisponiveis;
import br.com.ada.patitas.model.Veterinario;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HorariosDisponiveisMapper {
    public static List<HorariosDisponiveisDto>toDtoHorariosDisponiveis(final List<HorariosDisponiveis> horariosDisponiveis){
        return horariosDisponiveis.stream()
                .map(entity -> toDtoHorariosDisponiveis(entity))
                .collect(Collectors.toList());
    }
    public static HorariosDisponiveisDto toDtoHorariosDisponiveis(final HorariosDisponiveis horariosDisponiveis){
        if (Objects.nonNull(horariosDisponiveis)){
            return HorariosDisponiveisDto.builder()
                    .idVeterinario(horariosDisponiveis.getIdVeterinario())
                    .horariosDisponiveis(horariosDisponiveis.getHorariosDisponiveis())
                    .status(horariosDisponiveis.isStatus())
                    .build();

        }
        return HorariosDisponiveisDto.builder().build();
    }
    public static HorariosDisponiveis toEntityHorariosDisponiveis(final HorariosDisponiveisDto horariosDisponiveisDto){
        return HorariosDisponiveis.builder()
                .idVeterinario(horariosDisponiveisDto.getIdVeterinario())
                .horariosDisponiveis(horariosDisponiveisDto.getHorariosDisponiveis())
                .status(horariosDisponiveisDto.isStatus())
                .build();
    }

}
