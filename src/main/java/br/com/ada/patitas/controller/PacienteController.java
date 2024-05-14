package br.com.ada.patitas.controller;
import br.com.ada.patitas.dto.PacienteDto;
import br.com.ada.patitas.model.Paciente;
import br.com.ada.patitas.service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


import static br.com.ada.patitas.mapper.PacienteMapper.toDtoPaciente;
import static br.com.ada.patitas.mapper.PacienteMapper.toEntityPaciente;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping

    public ResponseEntity<List<PacienteDto>> findAll(){
List<Paciente> pacientes=pacienteService.findAll();
        return ResponseEntity.ok(toDtoPaciente(pacientes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> findById(@PathVariable("id") final Long id){
       final Optional<Paciente> optionalPaciente=pacienteService.findById(id);
       if(optionalPaciente.isEmpty()){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(toDtoPaciente(optionalPaciente.get()));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody final PacienteDto pacienteDto) throws Exception {
        pacienteService.cadastrar(toEntityPaciente(pacienteDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDto> atualizar(@PathVariable("id") final Long id,@Valid @RequestBody final PacienteDto pacienteAtualizado){
        final Optional<Paciente> optionalPaciente=pacienteService.atualizar(id, toEntityPaciente(pacienteAtualizado));
       if (optionalPaciente.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pacienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") final Long id) throws Exception {
        pacienteService.deletar(id);
        return ResponseEntity.noContent().build();

    }
}
