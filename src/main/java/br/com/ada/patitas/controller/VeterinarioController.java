package br.com.ada.patitas.controller;


import br.com.ada.patitas.dto.VeterinarioDto;
import br.com.ada.patitas.service.VeterinarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ada.patitas.model.Veterinario;

import java.util.List;
import java.util.Optional;


import static br.com.ada.patitas.mapper.VeterinarioMapper.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/veterinario")
public class VeterinarioController {
    @Autowired
    private VeterinarioService veterinarioService;


    @GetMapping
    public ResponseEntity<List<VeterinarioDto>> buscarTodosVeterinarios() {
        List<Veterinario> veterinarios = veterinarioService.buscarTodosVeterinarios();
        return ResponseEntity.ok(toDtoVeterinario(veterinarios));
    }

//    @GetMapping
//    public ResponseEntity<List<String>> buscarConsultasPorVeterinario(@PathVariable("id") final Long id) {
//        Optional<Veterinario> veterinarios = veterinarioService.buscarConsultasPorVeterinario(id);
//        return ResponseEntity.ok(toDtoVeterinario(veterinarios));
//
//    }

    @GetMapping("/{id}")
    public ResponseEntity<VeterinarioDto> buscarVeterinarioPorId(@PathVariable("id") final Long id) {
        final Optional<Veterinario> veterinarioOptional = veterinarioService.buscarVeterinarioPorId(id);
        if (veterinarioOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDtoVeterinarioDto(veterinarioOptional.get()));
    }


    @PostMapping
    public ResponseEntity<?> cadastrarVeterinario(@Valid @RequestBody VeterinarioDto veterinarioDto) throws Exception {
        veterinarioService.cadastrarVeterinario(toEntityVeterinario(veterinarioDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeterinarioDto> atualizarVeterinario(@PathVariable("id") final Long id, @Valid @RequestBody final VeterinarioDto veterinarioDto) {
        final Optional<Veterinario> veterinarioOptional = veterinarioService.atualizarVeterinario(id, toEntityVeterinario(veterinarioDto));
        if (veterinarioOptional.isEmpty())

            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(veterinarioDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeterinario(@PathVariable("id") Long id) throws Exception {
        veterinarioService.deletarVeterinario(id);
        return ResponseEntity.noContent().build();
    }
}
