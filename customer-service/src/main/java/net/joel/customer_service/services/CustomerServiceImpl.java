package net.joel.customer_service.services;

import net.joel.customer_service.entities.Customer;
import net.joel.customer_service.exceptions.CustomerNotFoundException;
import net.joel.customer_service.repositories.ICustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{

    private ICustomerRepository customerRepository;

    public CustomerServiceImpl(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer not found!"));
        return customer;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        Customer c = new Customer();
        c.setFirstName(customer.getFirstName());
        c.setLastName(customer.getLastName());
        c.setEmail(customer.getEmail());
        Customer customerSaved = customerRepository.save(c);
        return customerSaved;
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
        Customer c= getCustomer(customer.getId());
        c.setFirstName(customer.getFirstName());
        c.setLastName(customer.getLastName());
        c.setEmail(customer.getEmail());
        Customer updatedCustomer = customerRepository.save(c);
        return updatedCustomer;
    }

    @Override
    public void deleteCustomer(Long id) {
         customerRepository.deleteById(id);
    }
}
