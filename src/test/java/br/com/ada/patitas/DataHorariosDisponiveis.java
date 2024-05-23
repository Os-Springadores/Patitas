package br.com.ada.patitas;

import br.com.ada.patitas.model.*;

import java.time.LocalDateTime;
import java.util.List;

public class DataHorariosDisponiveis {
    private static Veterinario veterinario = new Veterinario(1L, "Israel", Especialidade.CIRURGIA_GERAL);

    public static List<HorariosDisponiveis> listaHorariosDisponiveis() {
        return List.of(
                new HorariosDisponiveis(1L, veterinario, LocalDateTime.of(2024, 07, 10, 15, 10), true),
                new HorariosDisponiveis(2L, veterinario, LocalDateTime.of(2024, 06, 05, 10, 15), true),
                new HorariosDisponiveis(3L, veterinario, LocalDateTime.of(2024, 10, 01, 14, 30), true)
        );
    }

    public static HorariosDisponiveis horariosDisponiveis() {
        return new HorariosDisponiveis(1L, veterinario, LocalDateTime.of(2024, 07, 10, 15, 10), true);
    }
}
