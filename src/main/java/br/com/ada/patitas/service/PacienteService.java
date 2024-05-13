package br.com.ada.patitas.service;

import br.com.ada.patitas.model.Paciente;
import java.util.List;
import java.util.Optional;


public interface PacienteService {
    List<Paciente> buscarTodos();

    Optional<Paciente> buscarPorId(final Long id);

    Paciente cadastrar(final Paciente paciente);

    Optional<Paciente> atualizar(final Long id, final Paciente pacienteAtualizado);

    void deletar(final Long id);


}

