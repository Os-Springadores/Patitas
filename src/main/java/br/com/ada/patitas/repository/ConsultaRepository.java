package br.com.ada.patitas.repository;

import br.com.ada.patitas.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
    Optional<Consulta> findById(Long id);

}
