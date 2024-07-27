package net.joel.customer_service.services;

import net.joel.customer_service.entities.Customer;
import net.joel.customer_service.exceptions.CustomerNotFoundException;

import java.util.List;

public interface ICustomerService {
    List<Customer> listCustomers();
    Customer getCustomer(Long id) throws CustomerNotFoundException;
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
    void deleteCustomer(Long id);
}
