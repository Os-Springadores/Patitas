package br.com.ada.patitas.dto;

import br.com.ada.patitas.model.Veterinario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HorariosDisponiveisDto {


    private Veterinario idVeterinario;


    private LocalDateTime horariosDisponiveis;

    private boolean status;
}
