package br.com.ada.patitas.service;


import br.com.ada.patitas.model.Veterinario;

import java.util.List;
import java.util.Optional;

public interface VeterinarioService {

    List<Veterinario> buscarTodosVeterinarios();

    Optional<Veterinario> buscarVeterinarioPorId(final Long id);

    Veterinario cadastrarVeterinario(final Veterinario veterinario) throws Exception;

    Optional<Veterinario> atualizarVeterinario(final Long id, final Veterinario veterinario);

    void deletarVeterinario(final Long id) throws Exception;

    List<String> buscarConsultasPorVeterinario(final Long id);


}
