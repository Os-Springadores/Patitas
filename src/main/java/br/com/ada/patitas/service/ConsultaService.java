package br.com.ada.patitas.service;

import br.com.ada.patitas.model.Consulta;


import java.util.List;
import java.util.Optional;


public interface ConsultaService {

    List<Consulta> findAll();

    Optional<Consulta>findById(final Long id);

    Consulta save(final Consulta consulta);

    Optional<Consulta>update(final Long id,final Consulta consulta);

    void delete(final Long id);


}
