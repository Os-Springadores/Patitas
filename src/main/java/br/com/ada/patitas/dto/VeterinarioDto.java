package br.com.ada.patitas.dto;


import br.com.ada.patitas.model.Especialidade;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeterinarioDto {

    @NotBlank(message = "O Atributo nome é obrigatório")
    private String nome;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Especialidade especialidade;


}
