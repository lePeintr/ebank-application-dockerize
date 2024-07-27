package net.joel.account_service.services;

import net.joel.account_service.clients.ICustomerRestClient;
import net.joel.account_service.entities.BankAccount;
import net.joel.account_service.exceptions.BankAccountNotFoundException;
import net.joel.account_service.models.Customer;
import net.joel.account_service.repositories.IBankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountServiceImpl implements IBankAccountService{

    private IBankAccountRepository bankAccountRepository;
    private ICustomerRestClient customerRestClient;

    public BankAccountServiceImpl(IBankAccountRepository bankAccountRepository,ICustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient= customerRestClient;
    }

    @Override
    public List<BankAccount> listBankAccount() {
        return bankAccountRepository.findAll();
    }

    @Override
    public BankAccount getBankAccountById(String accountId) throws BankAccountNotFoundException {
        BankAccount bankAccount = bankAccountRepository.findById(accountId).orElseThrow(()->new BankAccountNotFoundException("Bank Account not found!"));
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);

        return bankAccount;
    }

    @Override
    public BankAccount createBankAccount(BankAccount bankAccount) {
        return null;
    }

    @Override
    public BankAccount updateBankAccount(BankAccount bankAccount) {
        return null;
    }

    @Override
    public void deleteBankAccount(String accountId) {

    }
}
