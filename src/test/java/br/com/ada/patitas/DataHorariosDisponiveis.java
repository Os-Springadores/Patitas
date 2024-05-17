package br.com.ada.patitas;

import br.com.ada.patitas.model.HorariosDisponiveis;

import java.time.LocalDateTime;
import java.util.List;

public class DataHorariosDisponiveis {
    public static List<HorariosDisponiveis> listaHorariosDisponiveis() {
        return List.of(
                new HorariosDisponiveis(1l, 1l, LocalDateTime.parse("2024/05/18T24:15:30"), true),
                new HorariosDisponiveis(2l, 2l, LocalDateTime.parse("2024/06/08T24:08:30"), true),
                new HorariosDisponiveis(3l, 3l, LocalDateTime.parse("2024/07/04T24:19:30"), true)
        );
    }

    public static HorariosDisponiveis horariosDisponiveis() {
        return new HorariosDisponiveis(1l, 1l, LocalDateTime.parse("2024/05/18T24:15:30"), true);
    }

}
