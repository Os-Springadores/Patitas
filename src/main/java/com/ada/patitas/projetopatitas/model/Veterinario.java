package com.ada.patitas.projetopatitas.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_veterinario")
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    private Long id;

    @NotBlank(message = "O Atributo nome é obrigatório")
    @Column(name = "nome",length = 50,nullable = false)
    private String nome;

    private Especialidade especialidade;

    @ElementCollection
    private List<String> horariosDisponiveis;

}
