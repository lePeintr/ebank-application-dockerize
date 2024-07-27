package net.joel.account_service.web;

import net.joel.account_service.clients.ICustomerRestClient;
import net.joel.account_service.entities.BankAccount;
import net.joel.account_service.exceptions.BankAccountNotFoundException;
import net.joel.account_service.models.Customer;
import net.joel.account_service.services.IBankAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountRestController {

    private IBankAccountService bankAccountService;


    public BankAccountRestController(IBankAccountService bankAccountService,ICustomerRestClient customerRestClient){
        this.bankAccountService = bankAccountService;

    }

    @GetMapping("/accounts")
    public List<BankAccount> listBankAccount(){
        return bankAccountService.listBankAccount();
    }

    @GetMapping("/accounts/{accountId}")
    public BankAccount listBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccountById(accountId);
    }
}
