package br.com.ada.patitas;

import br.com.ada.patitas.model.Especialidade;
import br.com.ada.patitas.model.Veterinario;

import java.util.List;

public class DataVeterinario {
    public static List<Veterinario> listaVeterinario() {
        return List.of(
                new Veterinario(1L, "Israel", Especialidade.CIRURGIA_GERAL),
                new Veterinario(2L, "Joao", Especialidade.DERMATOLOGIA),
                new Veterinario(3L, "Gabriel", Especialidade.CARDIOLOGIA)
        );
    }

    public static Veterinario veterinario() {
        return new Veterinario(1L, "Israel", Especialidade.CIRURGIA_GERAL);

    }
}
