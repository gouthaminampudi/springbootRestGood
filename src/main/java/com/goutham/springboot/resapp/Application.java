/**
 * 
 */
package com.goutham.springboot.resapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.goutham.springboot.database.DTOEntity;
import com.goutham.springboot.database.SpringRepositoryInterface;

@EntityScan("com.goutham.springboot.database") //Need to use this if Entity is in a different package
@EnableJpaRepositories("com.goutham.springboot.database") //Need to use this if JPA Repository is in a different package
@SpringBootApplication
@CrossOrigin
public class Application extends SpringBootServletInitializer {

	private static final Logger log = LoggerFactory.getLogger(Application.class);


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}


	@Bean
	public CommandLineRunner demo(final SpringRepositoryInterface repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new DTOEntity("Jack", "Bauer"));
			repository.save(new DTOEntity("Chloe", "O'Brian"));
			repository.save(new DTOEntity("Kim", "Bauer"));
			repository.save(new DTOEntity("David", "Palmer"));
			repository.save(new DTOEntity("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (DTOEntity customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			for (DTOEntity customer : repository.findByFirstName("Jack")) {
				log.info(customer.toString());

			}


		};
	}
}
