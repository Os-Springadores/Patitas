package br.com.ada.patitas.serviceimpl;

import br.com.ada.patitas.exception.VeterinarioJaExisteException;
import br.com.ada.patitas.service.VeterinarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ada.patitas.model.Veterinario;
import br.com.ada.patitas.repository.VeterinarioRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VeterinarioServiceImpl implements VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Override
    public List<Veterinario> findAll() {
        return veterinarioRepository.findAll();
    }

    @Override
    public Optional<Veterinario> findById(Long id) {
        return veterinarioRepository.findById(id);
    }

    @Override
    public Veterinario save(Veterinario veterinario)  {
        if (veterinario.getId() == null || veterinarioRepository.findById(veterinario.getId()).isEmpty()) {
            return veterinarioRepository.save(veterinario);
        }
        throw new VeterinarioJaExisteException("O veterinario com id " + veterinario.getId() + "já existe");
    }

    @Override
    public Optional<Veterinario> update(final Long id, final Veterinario veterinarioAtualizado) {
        final Optional<Veterinario> veterinarioExistente = veterinarioRepository.findById(id);
        if (veterinarioExistente.isPresent()) {
            final Veterinario veterinarioEncontrado = veterinarioExistente.get();
            veterinarioEncontrado.setNome(veterinarioAtualizado.getNome());
            veterinarioEncontrado.setEspecialidade(veterinarioAtualizado.getEspecialidade());
            return Optional.of(veterinarioRepository.save(veterinarioEncontrado));
        }
        return veterinarioExistente;
    }
    @Override
    public void delete(Long id) {
        Optional<Veterinario> veterinarioOptional = veterinarioRepository.findById(id);
        if (veterinarioOptional.isEmpty()) {
            throw new VeterinarioJaExisteException("O veterinario com id " + id + " não existe!");
        }
        veterinarioRepository.delete(veterinarioOptional.get());
    }
}
