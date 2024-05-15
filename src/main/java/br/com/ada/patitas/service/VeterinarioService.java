package br.com.ada.patitas.service;


import br.com.ada.patitas.model.Veterinario;

import java.util.List;
import java.util.Optional;


public interface VeterinarioService {

    List<Veterinario> findAll();

    Optional<Veterinario> findById(final Long id);

    Veterinario save(final Veterinario veterinario) throws Exception;

    Optional<Veterinario> update(final Long id, final Veterinario veterinario);

    void delete(final Long id) throws Exception;



}
