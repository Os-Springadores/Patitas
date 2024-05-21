package br.com.ada.patitas.serviceimpl;

import br.com.ada.patitas.exception.ConsultaJaExisteException;
import br.com.ada.patitas.model.Consulta;
import br.com.ada.patitas.model.HorariosDisponiveis;
import br.com.ada.patitas.model.Paciente;
import br.com.ada.patitas.model.Veterinario;
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
    public Optional<Consulta> update(final Long id, final Consulta consultaAtualizado) {
        Veterinario veterinario = Veterinario.builder().id(consultaAtualizado.getVeterinario().getId()).build();
        Paciente paciente = Paciente.builder().id(consultaAtualizado.getPaciente().getId()).build();
        HorariosDisponiveis horariosDisponiveis = HorariosDisponiveis.builder().id(consultaAtualizado.getHorariosDisponiveis().getId()).build();

        Optional<Consulta> consultaExistente = consultaRepository.findById(id);
        if (consultaExistente.isPresent()) {
            final Consulta consultaEncontrado = consultaExistente.get();
            consultaEncontrado.setVeterinario(veterinario);
            consultaEncontrado.setPaciente(paciente);
            consultaEncontrado.setHorariosDisponiveis(horariosDisponiveis   );
            consultaEncontrado.setServico(consultaAtualizado.getServico());
            consultaEncontrado.setTipoServico(consultaAtualizado.getTipoServico());
            consultaEncontrado.setPreco(consultaAtualizado.getPreco());
            consultaEncontrado.setStatus(consultaAtualizado.isStatus());
            return Optional.of(consultaRepository.save(consultaEncontrado));
        }
        return consultaExistente;
    }

    @Override
    public void delete(Long id) {
        Optional<Consulta> consulta = consultaRepository.findById(id);
        if (consulta.isPresent()) {
            consultaRepository.delete(consulta.get());
        }
    }
}