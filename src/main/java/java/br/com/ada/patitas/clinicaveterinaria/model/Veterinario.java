package java.br.com.ada.patitas.clinicaveterinaria.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Especialidade especialidade;

    @ElementCollection
    @CollectionTable(name = "horarios_disponiveis",joinColumns = @JoinColumn(name = "veterinario_id"))
    @Column(name = "horario")
    private Set<String> horariosDisponiveis;

}
