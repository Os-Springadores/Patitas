package br.com.ada.patitas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ada.patitas.model.Paciente;
import br.com.ada.patitas.service.PacienteService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos(){
        List<Paciente> pacientes=pacienteService.buscarTodos();
        return new ResponseEntity<>(pacientes,HttpStatus.OK);
    }

    @GetMapping("/(id)")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable final Long id){
        Optional<Paciente> pacienteOptional=pacienteService.buscarPorId(id);
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
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        pacienteService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
