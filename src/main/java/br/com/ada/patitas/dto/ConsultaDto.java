package br.com.ada.patitas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaDto {

    private Long idVeterinario;

    private Long idPaciente;

    private Long idHorariosDisponiveis;

    private String motivoDaConsulta;

}