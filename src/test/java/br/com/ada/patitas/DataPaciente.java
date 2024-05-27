package br.com.ada.patitas;

import br.com.ada.patitas.model.Especie;
import br.com.ada.patitas.model.Paciente;

import java.util.List;

public class DataPaciente {


    public static List<Paciente> listaPaciente() {
        return List.of(
                new Paciente(1L, "pedrita", Especie.CACHORRO, "pituca", 5, 3.3),
                new Paciente(2L, "tictac", Especie.AVE, "gavião", 15, 10),
                new Paciente(3L, "mimoso", Especie.REPTIL, "crocodilo", 20, 300.3)
        );
    }

    public static Paciente paciente() {
        return  new Paciente(1L, "pedrita", Especie.CACHORRO, "pituca", 5, 3.3);
    }
}
