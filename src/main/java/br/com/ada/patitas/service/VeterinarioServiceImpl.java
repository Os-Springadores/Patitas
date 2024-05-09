package br.com.ada.patitas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.ada.patitas.model.Veterinario;
import br.com.ada.patitas.repository.VeterinarioRepository;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {


    @Autowired
    private VeterinarioRepository veterinarioRepository;


    @Override
    public List<Veterinario> buscarTodosVeterinarios() {
        return veterinarioRepository.findAll();
    }

    @Override
    public Optional<Veterinario> buscarVeterinarioPorId(Long id) {
        return veterinarioRepository.findById(id);
    }

    @Override
    public Veterinario cadastrarVeterinario(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    @Override
    public void atualizarVeterinario(Long id, Veterinario veterinario) {
        if (veterinarioRepository.existsById(id)) {
            veterinario.setId(id);
            veterinarioRepository.save(veterinario);
        } else {
            throw new ResponseStatusException(HttpStatusCode.valueOf(id.byteValue()));
        }


    }

    @Override
    public void deletarVeterinario(Long id) {
        veterinarioRepository.deleteById(id);
    }

    @Override
    public Set<String> buscarConsultasPorVeterinario(Long id) {
        Optional<Veterinario> veterinarioOptional = veterinarioRepository.findById(id);
        if (veterinarioOptional.isPresent()) {
            Veterinario veterinario = veterinarioOptional.get();
            return veterinario.getHorariosDisponiveis();
        }
        return null;
    }
}
