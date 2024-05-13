package br.com.ada.patitas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Table(name="paciente")
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
