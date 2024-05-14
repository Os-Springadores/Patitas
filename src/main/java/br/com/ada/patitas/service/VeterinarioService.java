package br.com.ada.patitas.service;


import br.com.ada.patitas.model.Veterinario;
import java.util.List;
import java.util.Optional;

import br.com.ada.patitas.model.Consulta;
import br.com.ada.patitas.model.Veterinario;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface VeterinarioService {


    List<Veterinario> buscarTodosVeterinarios();

    Optional<Veterinario> buscarVeterinarioPorId(Long id);

    Veterinario cadastrarVeterinario(Veterinario veterinario)throws Exception;


    Optional<Veterinario> atualizarVeterinario(Long id, Veterinario veterinario);

    void deletarVeterinario(Long id);

    List<String> buscarConsultasPorVeterinario(Long id);

 
}
