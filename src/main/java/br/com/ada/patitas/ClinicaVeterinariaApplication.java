package br.com.ada.patitas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaVeterinariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaVeterinariaApplication.class, args);
	}

}
Error creating bean with name 'veterinarioController': Unsatisfied dependency expressed through field 'veterinarioService': Error creating bean with name 'veterinarioServiceImpl': Unsatisfied dependency expressed through field 'veterinarioRepository': Error creating bean with name 'veterinarioRepository' defined in br.com.ada.patitas.repository.VeterinarioRepository defined in @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration: Could not create query for public abstract java.util.List br.com.ada.patitas.repository.VeterinarioRepository.findByConsultasNull(); Reason: Failed to create query for method public abstract java.util.List br.com.ada.patitas.repository.VeterinarioRepository.findByConsultasNull(); No property 'consultas' found for type 'Veterinario'
