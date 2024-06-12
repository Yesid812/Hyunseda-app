package co.hyunseda.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication // Anotación que marca esta clase como una clase de aplicación Spring Boot
@EntityScan(basePackages = "co.hyunseda.client.Infrastructure.Entity") // Escanea y registra las entidades JPA en el paquete especificado
@EnableJpaRepositories(basePackages = "co.hyunseda.client.Domain.Puerto") // Habilita los repositorios JPA en el paquete especificado
public class ClientApplication {

	public static void main(String[] args) {
		// Método principal que inicia la aplicación Spring Boot
		SpringApplication.run(ClientApplication.class, args);
	}

}
