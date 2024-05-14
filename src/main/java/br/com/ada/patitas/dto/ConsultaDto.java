package br.com.ada.patitas.dto;

import br.com.ada.patitas.model.Paciente;
import br.com.ada.patitas.model.Veterinario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaDto {

    private Veterinario veterinario;

    private Paciente paciente;

    @NotBlank(message = "O Atributo data é obrigatório")
    private Date data;

    @NotBlank(message = "O Atributo hora é obrigatório")
    private Date hora;

}
