package com.ada.patitas.projetopatitas.repository;


import com.ada.patitas.projetopatitas.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    Optional<Paciente> findById(Long id);
}
