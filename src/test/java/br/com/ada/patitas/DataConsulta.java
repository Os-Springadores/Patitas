package br.com.ada.patitas;

import br.com.ada.patitas.model.Consulta;

import java.util.List;

public class DataConsulta {
    public static List<Consulta> listaDeConsultas() {
        return List.of(
                new Consulta(
                        1l,
                        1l,
                        1l,
                        1l,
                        "Paciente com fratura em um dos membros")
        );
    }

    public static Consulta consulta() {
        return new Consulta(1l,
                1l,
                1l,
                1l,
                "Paciente com fratura em um dos membros");
    }
}
