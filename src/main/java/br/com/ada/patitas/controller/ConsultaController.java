package br.com.ada.patitas.controller;


import br.com.ada.patitas.dto.ConsultaDto;

import br.com.ada.patitas.model.Consulta;
import br.com.ada.patitas.model.HorariosDisponiveis;

import br.com.ada.patitas.model.Veterinario;
import br.com.ada.patitas.repository.HorariosDisponiveisRepository;

import br.com.ada.patitas.repository.VeterinarioRepository;
import br.com.ada.patitas.service.ConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;


import java.util.List;


import java.util.Optional;

import static br.com.ada.patitas.mapper.ConsultaMapper.*;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private final ConsultaService consultaService;
    private final HorariosDisponiveisRepository horariosDisponiveisRepository;
    private final VeterinarioRepository veterinarioRepository;

    @GetMapping
    public ResponseEntity<List<ConsultaDto>> findAll() {
        List<Consulta> consultas = consultaService.findAll();
        return ResponseEntity.ok(toDtoConsulta(consultas));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDto> findById(@PathVariable("id") final Long id) {
        final Optional<Consulta> consultaOptional = consultaService.findById(id);
        if (consultaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDtoConsultaDto(consultaOptional.get()));

    }

    @PostMapping
    public ResponseEntity<Consulta> save(@Valid @RequestBody final ConsultaDto consultaDto) {

        HorariosDisponiveis horario = horariosDisponiveisRepository.findById(consultaDto.getIdHorariosDisponiveis()).orElse(null);
        Veterinario veterinario = veterinarioRepository.findById(consultaDto.getIdVeterinario()).orElse(null);

        if (veterinario == null || !veterinario.getEspecialidade().contem(consultaDto.getServico())) {
            return ResponseEntity.badRequest().build();
        }
        if (horario == null || !horario.isStatus()) {
            return ResponseEntity.badRequest().build();
        }
        Consulta consultaDisponivel = consultaService.save(toEntityConsulta(consultaDto));
        horario.setStatus(false);
        horariosDisponiveisRepository.save(horario);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaDisponivel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDto> update(@PathVariable("id") final Long id, @Valid @RequestBody final ConsultaDto consultaAtualizado) {
        final Optional<Consulta> optionalConsulta = consultaService.update(id, toEntityConsulta(consultaAtualizado));
        if (optionalConsulta.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(consultaAtualizado);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
        consultaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}