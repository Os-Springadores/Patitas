package java.br.com.ada.patitas.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Paciente {

    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private int tipo;
}
