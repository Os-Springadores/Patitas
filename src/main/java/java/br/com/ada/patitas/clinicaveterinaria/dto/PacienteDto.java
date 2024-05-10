package java.br.com.ada.patitas.clinicaveterinaria.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.br.com.ada.patitas.clinicaveterinaria.model.Especie;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDto {

    private Long id;

    private String nome;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Especie especie;

    private String raca;

    private int idade;

    private double peso;
}
