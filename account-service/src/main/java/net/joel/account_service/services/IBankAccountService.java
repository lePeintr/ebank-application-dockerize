package net.joel.account_service.services;

import net.joel.account_service.entities.BankAccount;
import net.joel.account_service.exceptions.BankAccountNotFoundException;

import java.util.List;

public interface IBankAccountService {
    List<BankAccount> listBankAccount();
    BankAccount getBankAccountById(String accountId) throws BankAccountNotFoundException;
    BankAccount createBankAccount(BankAccount bankAccount);
    BankAccount updateBankAccount(BankAccount bankAccount);
    void deleteBankAccount(String accountId);
   // List<OperationBankAccount> listOperationBankAccount(String accountId);
}
