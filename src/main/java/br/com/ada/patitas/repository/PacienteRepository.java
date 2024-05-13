package br.com.ada.patitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ada.patitas.model.Paciente;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    Optional<Paciente> findById(Long id);
}
