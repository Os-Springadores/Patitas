package br.com.ada.patitas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class PatitasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatitasApplication.class, args);
	}
}
