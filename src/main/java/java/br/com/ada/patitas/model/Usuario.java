package java.br.com.ada.patitas.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {
    private Long id;
    private String nome;
    private int idade;
    private String cpf;
}
