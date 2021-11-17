package io.github.iaagofelipe.service;

import io.github.iaagofelipe.model.Customer;
import io.github.iaagofelipe.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void saveCustomer(Customer customer){
        validateCustomer(customer);
        this.repository.persist(customer);
    }

    public void validateCustomer(Customer customer) {
        //TODO apply validations
    }
}
