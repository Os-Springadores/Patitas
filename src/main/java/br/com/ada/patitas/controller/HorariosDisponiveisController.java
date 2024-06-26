package br.com.ada.patitas.controller;


import br.com.ada.patitas.dto.HorariosDisponiveisDto;
import br.com.ada.patitas.model.HorariosDisponiveis;
import br.com.ada.patitas.model.Veterinario;
import br.com.ada.patitas.repository.VeterinarioRepository;
import br.com.ada.patitas.service.HorariosDisponiveisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static br.com.ada.patitas.mapper.HorariosDisponiveisMapper.toDtoHorariosDisponiveis;
import static br.com.ada.patitas.mapper.HorariosDisponiveisMapper.toEntityHorariosDisponiveis;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/horariosDisponiveis")
public class HorariosDisponiveisController {

    @Autowired
    private HorariosDisponiveisService horariosDisponiveisService;
    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @GetMapping
    public ResponseEntity<List<HorariosDisponiveisDto>> findAll() {
        List<HorariosDisponiveis> horariosDisponiveis = horariosDisponiveisService.findAll();
        return ResponseEntity.ok(toDtoHorariosDisponiveis(horariosDisponiveis));
    }

    @PostMapping
    public ResponseEntity<HorariosDisponiveis> save(@Valid @RequestBody HorariosDisponiveisDto horariosDisponiveisDto) throws Exception {

        Optional<Veterinario> veterinarioOptional = veterinarioRepository.findById(horariosDisponiveisDto.getIdVeterinario());
        if (veterinarioOptional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        horariosDisponiveisService.save(toEntityHorariosDisponiveis(horariosDisponiveisDto));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

