package io.github.iaagofelipe.rest;

import io.github.iaagofelipe.model.entity.Customer;
import io.github.iaagofelipe.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerRepository repository;

    @Autowired
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody @Valid Customer customer){
        return repository.save(customer);
    }

    @GetMapping("{id}")
    public Customer searchId(@PathVariable Integer id) {
        return repository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        repository
                .findById(id)
                .map(customer -> {
                    repository.delete(customer);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void refresh(@PathVariable Integer id, @RequestBody Customer refreshedCustomer){
        repository.findById(id)
                .map(customer -> {
                    refreshedCustomer.setId(customer.getId());
                    return repository.save(refreshedCustomer);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
