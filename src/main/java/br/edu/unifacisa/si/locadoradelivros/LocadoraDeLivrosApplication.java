package br.edu.unifacisa.si.locadoradelivros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EntityScan(basePackages = { "br.edu.unifacisa.si.locadoradelivros.domain" })

@EnableJpaRepositories(basePackages = { "br.edu.unifacisa.si.locadoradelivros.repository" })

public class LocadoraDeLivrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocadoraDeLivrosApplication.class, args);
	}

}
