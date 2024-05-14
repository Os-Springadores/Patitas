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
    public Veterinario cadastrarVeterinario(Veterinario veterinario) throws Exception {
        if (veterinario.getId() == null || veterinarioRepository.findById(veterinario.getId()).isEmpty()) {
            return veterinarioRepository.save(veterinario);
        }
        throw new Exception("O veterinario com id " + veterinario.getId() + "já existe");
    }


    @Override
    public Optional<Veterinario> atualizarVeterinario(final Long id, final Veterinario veterinarioAtualizado) {
        Optional<Veterinario> veterinarioExistente = veterinarioRepository.findById(id);
        if (veterinarioExistente.isPresent()) {
            final Veterinario veterinarioEncontrado = veterinarioExistente.get();
            veterinarioEncontrado.setNome(veterinarioAtualizado.getNome());
            veterinarioEncontrado.setEspecialidade(veterinarioAtualizado.getEspecialidade());
            veterinarioEncontrado.setHorariosDisponiveis(veterinarioAtualizado.getHorariosDisponiveis());
            return Optional.of(veterinarioRepository.save(veterinarioAtualizado));
        }
        return veterinarioExistente;
    }


    @Override
    public void deletarVeterinario(Long id) throws Exception {
        Optional<Veterinario> veterinarioOptional = veterinarioRepository.findById(id);
        if (veterinarioOptional.isEmpty()) {
            throw new Exception("O veterinario com id " + id + "não existe!");
        }
        veterinarioRepository.delete(veterinarioOptional.get());
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
