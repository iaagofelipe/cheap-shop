package io.github.iaagofelipe.repository;

import io.github.iaagofelipe.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
    public void persist(Customer customer) {
        //TODO acess database and save a customer
    }
}
