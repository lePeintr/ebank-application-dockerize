package net.joel.account_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.joel.account_service.enums.AccountStatus;
import net.joel.account_service.enums.AccountType;
import net.joel.account_service.models.Customer;


import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @Transient //demande a JPA de l'ignorer car customer n'est pas une entity dans ce micro service.Customer est une simple classe
    //qui n'est pas représenter dans la base de donnée
    private Customer customer;
    private Long customerId;//la clé secondaire de l'id de customer qui est clé primaire dans le micro-service customer-service

}
