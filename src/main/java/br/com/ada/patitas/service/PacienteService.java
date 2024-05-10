package br.com.ada.patitas.service;

import br.com.ada.patitas.model.Paciente;
import java.util.List;
import java.util.Optional;


public interface PacienteService {
    List<Paciente> buscarTodos();

    Optional<Paciente> buscarPorId(final Long id);

    Paciente cadastrar(final Paciente paciente);

    Optional<Paciente> atualizar(final Long id, final Paciente pacienteAtualizado);

    void deletar(final Long id);


}
import br.com.ada.patitas.model.Paciente;
import br.com.ada.patitas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Paciente cadastrar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Optional<Paciente> atualizar(Long id, Paciente pacienteAtualizado) {
        Optional<Paciente> pacienteExistente = pacienteRepository.findById(id);
        if (pacienteExistente.isPresent()) {
            pacienteAtualizado.setId(id); // Garantindo que o ID seja o mesmo do paciente existente
            return Optional.of(pacienteRepository.save(pacienteAtualizado));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deletar(Long id) {
        pacienteRepository.deleteById(id);
    }
}
