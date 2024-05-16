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
    public ResponseEntity<List<VeterinarioDto>> findAll() {
        List<Veterinario> veterinarios = veterinarioService.findAll();
        return ResponseEntity.ok(toDtoVeterinario(veterinarios));
    }


    @GetMapping("/{id}")
    public ResponseEntity<VeterinarioDto> findById(@PathVariable("id") final Long id) {
        final Optional<Veterinario> veterinarioOptional = veterinarioService.findById(id);
        if (veterinarioOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDtoVeterinarioDto(veterinarioOptional.get()));
    }


    @PostMapping
    public ResponseEntity<Veterinario> save(@Valid @RequestBody VeterinarioDto veterinarioDto) throws Exception {
        veterinarioService.save(toEntityVeterinario(veterinarioDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeterinarioDto> update(@PathVariable("id") final Long id, @Valid @RequestBody final VeterinarioDto veterinarioDto) {
        final Optional<Veterinario> veterinarioOptional = veterinarioService.update(id, toEntityVeterinario(veterinarioDto));
        if (veterinarioOptional.isEmpty()) {

            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(veterinarioDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
        veterinarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
