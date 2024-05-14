package br.com.ada.patitas.serviceimpl;

import br.com.ada.patitas.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.ada.patitas.model.Paciente;
import br.com.ada.patitas.repository.PacienteRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> findById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Paciente cadastrar(final Paciente entity) throws Exception {
        if (entity.getId() == null || pacienteRepository.findById(entity.getId()).isEmpty()) {
            return pacienteRepository.save(entity);
        }
        throw new Exception("O paciente com id " + entity.getId() + " já existe");
    }

    @Override
    public Optional<Paciente> atualizar(final Long id, final Paciente pacienteAtualizado) {
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