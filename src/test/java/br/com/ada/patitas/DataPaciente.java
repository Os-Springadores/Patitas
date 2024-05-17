package br.com.ada.patitas;

import br.com.ada.patitas.model.Especie;
import br.com.ada.patitas.model.Paciente;

import java.util.List;

public class DataPaciente {
    public static List<Paciente> listaDePaciente() {
        return List.of(
                new Paciente(1l, "Taruga", Especie.MAMIFERO, "cachorro", 12, 17.0),
                new Paciente(2l, "navi", Especie.REPTIL, "crocodilo", 20, 370.0),
                new Paciente(3l, "napoleao", Especie.AVE, "papagaio", 5, 2)
        );
    }

    public static Paciente paciente() {
        return new Paciente(1l, "Taruga", Especie.MAMIFERO, "cachorro", 12, 17.0);

    }
}
