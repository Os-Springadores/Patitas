package br.com.ada.patitas.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_paciente")
@Builder
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Atributo nome é obrigatório")
    private String nome;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EspeciePaciente especie;

    @NotBlank(message = "O Atributo raça é obrigatório")
    private String raca;

    private int idade;

    @NotBlank(message = "O Atributo peso é obrigatório")
    private double peso;
}
