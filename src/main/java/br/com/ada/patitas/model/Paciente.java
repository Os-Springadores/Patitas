package br.com.ada.patitas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name="tb_paciente")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Especie especie;
  
    private String raca;
  
    private int idade;
  
    private double peso;

}
