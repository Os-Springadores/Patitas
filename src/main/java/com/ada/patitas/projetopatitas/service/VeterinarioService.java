package com.ada.patitas.projetopatitas.service;


import com.ada.patitas.projetopatitas.model.Veterinario;

import java.util.List;
import java.util.Optional;

public interface VeterinarioService {


    List<Veterinario> buscarTodosVeterinarios();

    Optional<Veterinario> buscarVeterinarioPorId(Long id);

    Veterinario cadastrarVeterinario(Veterinario veterinario);

    Optional<Veterinario> atualizarVeterinario(Long id, Veterinario veterinario);

    void deletarVeterinario(Long id);

    List<String> buscarConsultasPorVeterinario(Long id);
}
