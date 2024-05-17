package br.com.ada.patitas;

import br.com.ada.patitas.model.Especialidade;
import br.com.ada.patitas.model.Veterinario;

import java.util.List;

public class DataVeterinario {
    public static List<Veterinario> listaDeVeterinario() {
        return List.of(
                new Veterinario(1l, "israel", Especialidade.CIRURGIAO),
                new Veterinario(2l, "Jhenny", Especialidade.CARDIOLOGISTA),
                new Veterinario(3l, "Gabriel", Especialidade.ENDOCRINOLOGISTA)
        );
    }

    public static Veterinario veterinario() {
        return new Veterinario(1l, "israel", Especialidade.CIRURGIAO);

    }
}
