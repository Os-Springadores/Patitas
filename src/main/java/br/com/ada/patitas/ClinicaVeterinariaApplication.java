package br.com.ada.patitas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaVeterinariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaVeterinariaApplication.class, args);
	}

}


Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2024-05-16T08:52:50.736-03:00 ERROR 22220 --- [projetopatitas] [  restartedMain] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Could not determine recommended JdbcType for Java type 'br.com.ada.patitas.model.Veterinario'
	
