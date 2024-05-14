package br.com.ada.patitas.service;

import br.com.ada.patitas.model.Paciente;
import java.util.List;
import java.util.Optional;


public interface PacienteService {

    List<Paciente> findAll();

    Optional<Paciente> findById(final Long id);

    Paciente cadastrar(final Paciente paciente) throws Exception;

    Optional<Paciente> atualizar(final Long id, final Paciente pacienteAtualizado);

    void deletar(final Long id) throws Exception;


}

