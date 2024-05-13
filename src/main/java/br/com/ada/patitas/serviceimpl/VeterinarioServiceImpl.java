package br.com.ada.patitas.serviceimpl;

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
    public Optional<Veterinario> atualizarVeterinario(Long id, Veterinario veterinarioAtualizado) {
        Optional<Veterinario> veterinarioExistente = veterinarioRepository.findById(id);
        if (veterinarioExistente.isPresent()) {
            veterinarioAtualizado.setId(id);
            return Optional.of(veterinarioRepository.save(veterinarioAtualizado));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deletarVeterinario(Long id) {
        veterinarioRepository.deleteById(id);
    }

    @Override
    public List<String> buscarConsultasPorVeterinario(Long id) {
        Optional<Veterinario> veterinarioOptional = veterinarioRepository.findById(id);
        if (veterinarioOptional.isPresent()) {
            Veterinario veterinario = veterinarioOptional.get();
            return veterinario.getHorariosDisponiveis();
        }
        return null;
    }
}
