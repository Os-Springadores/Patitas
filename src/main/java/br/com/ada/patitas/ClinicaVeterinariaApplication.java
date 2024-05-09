package br.com.ada.patitas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaVeterinariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaVeterinariaApplication.class, args);
	}

}
Error creating bean with name 'veterinarioController': Unsatisfied dependency expressed through field 'veterinarioService': Error creating bean with name 'veterinarioServiceImpl': Unsatisfied dependency expressed through field 'veterinarioRepository': Error creating bean with name 'veterinarioRepository' defined in br.com.ada.patitas.repository.VeterinarioRepository defined in @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration: Could not create query for public abstract java.util.List br.com.ada.patitas.repository.VeterinarioRepository.horariosDisponiveis(java.lang.Long); Reason: Failed to create query for method public abstract java.util.List br.com.ada.patitas.repository.VeterinarioRepository.horariosDisponiveis(java.lang.Long); Cannot compare left expression of type 'java.lang.String' with right expression of type 'java.lang.Long'
