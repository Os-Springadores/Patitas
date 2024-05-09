package br.com.ada.patitas.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ada.patitas.model.Veterinario;
import java.util.List;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
        List<Veterinario>horariosDisponiveis(Long id);
}
