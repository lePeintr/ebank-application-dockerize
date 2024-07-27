package net.joel.account_service.repositories;

import net.joel.account_service.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBankAccountRepository extends JpaRepository<BankAccount, String> {
}
