package br.com.ada.patitas.serviceimpl;

import br.com.ada.patitas.exception.ConsultaJaExisteException;
import br.com.ada.patitas.model.Consulta;
import br.com.ada.patitas.repository.ConsultaRepository;
import br.com.ada.patitas.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;

    @Override
    public List<Consulta> findAll() {

        return consultaRepository.findAll();
    }

    @Override
    public Optional<Consulta> findById(Long id) {

        return consultaRepository.findById(id);
    }

    @Override
    public Consulta save(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Override
    public Optional<Consulta> update(Long id, Consulta consultaAtualizado) {
        final Optional<Consulta> consultaOptional = consultaRepository.findById(id);
        if (consultaOptional.isPresent()) {
            final Consulta consultaEncontrada = consultaOptional.get();
            consultaEncontrada.setIdVeterinario(consultaAtualizado.getIdVeterinario());
            consultaEncontrada.setIdPaciente(consultaAtualizado.getIdPaciente());
            consultaEncontrada.setIdHorariosDisponiveis(consultaAtualizado.getIdHorariosDisponiveis());
            consultaRepository.save(consultaEncontrada);
            return Optional.of(consultaAtualizado);
        }
        return consultaOptional;
    }

    @Override
    public void delete(Long id) {
        Optional<Consulta> consulta = consultaRepository.findById(id);
        if (consulta.isPresent()) {
            consultaRepository.delete(consulta.get());
        }
    }
}
