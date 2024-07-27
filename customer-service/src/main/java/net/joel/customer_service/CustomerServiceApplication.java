package net.joel.customer_service;

import net.joel.customer_service.config.GlobalConfig;
import net.joel.customer_service.entities.Customer;
import net.joel.customer_service.repositories.ICustomerRepository;
import net.joel.customer_service.services.ICustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ICustomerRepository customerRepository) {
		return args -> {
					Stream.of("vini", "mbappe", "rodrygo").forEach(firstName -> {
									Stream.of("jr","Kylian","Goes").forEach(lastName->{
										Customer customer = new Customer();
										customer.setFirstName(firstName);
										customer.setLastName(lastName);
										customer.setEmail(firstName + "@gmail.com");
										customerRepository.save(customer);
									});

					});

		};
	}
}