package br.com.ada.patitas.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Veterinario veterinario;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "horarios_disponiveis_id")
    private HorariosDisponiveis horariosDisponiveis;

    @Enumerated(EnumType.STRING)
    @Column(name = "servico")
    private Servico servico;

    @Column(name = "tipo_servico")
    private String tipoServico;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "status")
    private boolean status;

}