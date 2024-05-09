package java.br.com.ada.patitas.service;

import java.br.com.ada.patitas.model.Consulta;
import java.br.com.ada.patitas.model.Veterinario;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface VeterinarioService {


    List<Veterinario> buscarTodosVeterinarios();

    Optional<Veterinario> buscarVeterinarioPorId(Long id);

    Veterinario cadastrarVeterinario(Veterinario veterinario);

    void atualizarVeterinario(Long id, Veterinario veterinario);

    void deletarVeterinario(Long id);

    Set<Consulta> buscarConsultasPorVeterinario(Long id);
}
