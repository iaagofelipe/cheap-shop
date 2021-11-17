package io.github.iaagofelipe.model.repository;

import io.github.iaagofelipe.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
