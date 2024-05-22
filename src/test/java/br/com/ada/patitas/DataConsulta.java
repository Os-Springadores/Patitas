package br.com.ada.patitas;

import br.com.ada.patitas.model.*;

import java.time.LocalDateTime;
import java.util.List;

public class DataConsulta {
    private static Veterinario veterinario = new Veterinario(1L, "Israel", Especialidade.CIRURGIA_GERAL);
    private static Paciente paciente = new Paciente(1L, "pedrita", Especie.MAMIFERO, "pituca", 5, 3.3);
    private static HorariosDisponiveis horariosDisponiveis = new HorariosDisponiveis(1L, veterinario, LocalDateTime.of(2024, 05, 20, 15, 5), true);

    public static List<Consulta> listaDeConsultas() {

        return List.of(
                new Consulta(1L, veterinario, paciente, horariosDisponiveis, Servico.CIRURGIA, "Castração", 250.0, true),
                new Consulta(2L, veterinario, paciente, horariosDisponiveis, Servico.ATENDIMENTO_EMERGENCIAL, "Raio-X", 50.0, true),
                new Consulta(3L, veterinario, paciente, horariosDisponiveis, Servico.ATENDIMENTO_CLINICO, "Consulta", 100.0, true));
    }

    public static Consulta consulta() {

        return new Consulta(1L, veterinario, paciente, horariosDisponiveis, Servico.CIRURGIA, "Castração", 250.0, true);


    }
}