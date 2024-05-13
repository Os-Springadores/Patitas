package com.ada.patitas.projetopatitas.repository;


import com.ada.patitas.projetopatitas.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
        Optional<Veterinario> findById(Long id);
}
