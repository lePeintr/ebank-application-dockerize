package net.joel.account_service;

import net.joel.account_service.clients.ICustomerRestClient;
import net.joel.account_service.entities.BankAccount;
import net.joel.account_service.enums.AccountType;
import net.joel.account_service.repositories.IBankAccountRepository;
import net.joel.account_service.services.IBankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(IBankAccountRepository bankAccountRepository, ICustomerRestClient customerRestClient){
		return args -> {
			customerRestClient.allCustomers().forEach(c->{
				BankAccount bankAccount1 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("Euro")
						.balance(Math.random()*80000)
						.createdAt(LocalDate.now())
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(c.getId())
						.build();
				BankAccount bankAccount2 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("Euro")
						.balance((Math.random()*65741))
						.createdAt(LocalDate.now())
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(c.getId())
						.build();
				bankAccountRepository.save(bankAccount1);
				bankAccountRepository.save(bankAccount2);
			});

			/*BankAccount bankAccount1 = BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("Euro")
					.balance(5000)
					.createdAt(LocalDate.now())
					.type(AccountType.CURRENT_ACCOUNT)
					.customerId(Long.valueOf(1))
					.build();
			BankAccount bankAccount2 = BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("Euro")
					.balance(100000)
					.createdAt(LocalDate.now())
					.type(AccountType.SAVING_ACCOUNT)
					.customerId(Long.valueOf(1))
					.build();
			BankAccount bankAccount3 = BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("Euro")
					.balance(9000)
					.createdAt(LocalDate.now())
					.type(AccountType.CURRENT_ACCOUNT)
					.customerId(Long.valueOf(2))
					.build();
			BankAccount bankAccount4 = BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("Euro")
					.balance(7000)
					.createdAt(LocalDate.now())
					.type(AccountType.SAVING_ACCOUNT)
					.customerId(Long.valueOf(2))
					.build();
			bankAccountRepository.save(bankAccount1);
			bankAccountRepository.save(bankAccount2);
			bankAccountRepository.save(bankAccount3);
			bankAccountRepository.save(bankAccount4);*/
		};
	}
}
