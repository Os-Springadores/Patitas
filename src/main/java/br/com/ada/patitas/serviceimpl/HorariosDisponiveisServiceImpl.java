package br.com.ada.patitas.serviceimpl;

import br.com.ada.patitas.exception.ConsultaJaExisteException;
import br.com.ada.patitas.model.HorariosDisponiveis;
import br.com.ada.patitas.repository.HorariosDisponiveisRepository;
import br.com.ada.patitas.service.HorariosDisponiveisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class HorariosDisponiveisServiceImpl implements HorariosDisponiveisService {

    private final HorariosDisponiveisRepository horariosDisponiveisRepository;

    @Override
    public List<HorariosDisponiveis> findAll() {
        return horariosDisponiveisRepository.findAll();
    }

    @Override
    public HorariosDisponiveis save(HorariosDisponiveis horariosDisponiveis) {
        if (horariosDisponiveisRepository.findById(horariosDisponiveis.getId()).isPresent()) {
           // throw new ConsultaJaExisteException("A consulta com id " + horariosDisponiveis.getId() + "já existe!");
        }
        return horariosDisponiveisRepository.save(horariosDisponiveis);
    }
}
