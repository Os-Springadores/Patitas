package java.br.com.ada.patitas.clinicaveterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.br.com.ada.patitas.clinicaveterinaria.model.Paciente;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    Optional<Paciente> findById(Long id);
}
