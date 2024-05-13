package br.com.ada.patitas.clinicaveterinaria.controller;

import br.com.ada.patitas.clinicaveterinaria.model.Paciente;
import br.com.ada.patitas.clinicaveterinaria.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> findAll(){
        List<Paciente> pacientes=pacienteService.findAll();
        return new ResponseEntity<>(pacientes,HttpStatus.OK);
    }

    @GetMapping("/(id)")
    public ResponseEntity<Paciente> findById(@PathVariable final Long id){
        Optional<Paciente> pacienteOptional=pacienteService.findById(id);
        return pacienteOptional.map(value -> new ResponseEntity<>(value,HttpStatus.OK))
        .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Paciente> cadastrar(@RequestBody final Paciente paciente){
        Paciente pacienteNovo=pacienteService.cadastrar(paciente);
        return new ResponseEntity<>(pacienteNovo,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id,@RequestBody Paciente paciente){
        pacienteService.atualizar(id,paciente);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(@PathVariable Long id) throws Exception {
        pacienteService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
