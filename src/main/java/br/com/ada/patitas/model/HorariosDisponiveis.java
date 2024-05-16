package br.com.ada.patitas.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_horariosDisponiveis")
public class HorariosDisponiveis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "veterinario_id")
    private Long idVeterinario;

    private LocalDateTime horariosDisponiveis;

    private boolean status;
}
