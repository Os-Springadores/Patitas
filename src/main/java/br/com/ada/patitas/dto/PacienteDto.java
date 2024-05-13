package br.com.ada.patitas.dto;

import br.com.ada.patitas.model.EspeciePaciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDto {

    private Long id;

    @NotBlank(message = "O Atributo nome é obrigatório")
    private String nome;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private EspeciePaciente especie;

    @NotBlank(message = "O Atributo raça é obrigatório")
    private String raca;

    private int idade;

    @NotBlank(message = "O Atributo peso é obrigatório")
    private double peso;
}
