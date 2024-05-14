package br.com.ada.patitas.service;

import br.com.ada.patitas.model.Paciente;


import java.util.List;
import java.util.Optional;


public interface PacienteService {

    List<Paciente> findAll();

    Optional<Paciente> findById(final Long id);

    Paciente save(final Paciente paciente) throws Exception;

    Optional<Paciente> update(final Long id, final Paciente pacienteAtualizado);

    void delete(final Long id) throws Exception;


}

