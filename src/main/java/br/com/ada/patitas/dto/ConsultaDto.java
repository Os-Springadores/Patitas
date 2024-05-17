package br.com.ada.patitas.dto;

import br.com.ada.patitas.model.HorariosDisponiveis;
import br.com.ada.patitas.model.Paciente;
import br.com.ada.patitas.model.Servico;
import br.com.ada.patitas.model.Veterinario;
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

    private Servico servico;
    private String tipoServico;
    private Double preco;


}