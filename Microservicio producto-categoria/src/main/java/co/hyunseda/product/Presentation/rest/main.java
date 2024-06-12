package co.hyunseda.product.Presentation.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"co.hyunseda.product"})
@EntityScan(basePackages = "co.hyunseda.product.domain.entity")
@EnableJpaRepositories(basePackages = "co.hyunseda.product.access")
public class main {
    public static void main(String[] args)
    {
        SpringApplication.run(main.class,args);
    }
}
