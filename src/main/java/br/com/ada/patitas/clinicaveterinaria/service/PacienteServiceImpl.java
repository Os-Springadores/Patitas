package br.com.ada.patitas.clinicaveterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ada.patitas.clinicaveterinaria.model.Paciente;
import br.com.ada.patitas.clinicaveterinaria.repository.PacienteRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> findById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Paciente cadastrar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Optional<Paciente> atualizar(final Long id, Paciente pacienteAtualizado) {
        final Optional<Paciente> pacienteExistente = pacienteRepository.findById(id);
        if (pacienteExistente.isPresent()) {
            final Paciente pacienteEncontrado = pacienteExistente.get();
            pacienteEncontrado.setNome(pacienteAtualizado.getNome());
            pacienteEncontrado.setEspecie(pacienteAtualizado.getEspecie());
            pacienteEncontrado.setRaca(pacienteAtualizado.getRaca());
            pacienteEncontrado.setIdade(pacienteAtualizado.getIdade());
            pacienteEncontrado.setPeso(pacienteAtualizado.getPeso());
            return Optional.of(pacienteRepository.save(pacienteEncontrado));
        }
            return pacienteExistente;
    }

    @Override
    public void deletar(Long id) throws Exception {
        Optional<Paciente> entity = pacienteRepository.findById(id);

        if (entity.isEmpty()) {
            throw new Exception("O cliente com id " + id + " não existe!");
        }
        pacienteRepository.delete(entity.get());
    }
}
