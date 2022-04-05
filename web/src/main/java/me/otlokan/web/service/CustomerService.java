package me.otlokan.web.service;

import lombok.RequiredArgsConstructor;
import me.otlokan.web.domain.Article;
import me.otlokan.web.domain.Customer;
import me.otlokan.web.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    @PostConstruct
    public void init() {
        add(new Customer(1, "Marko", "Otlokan", "123456", "0631287023"));
        add(new Customer(2, "Nikola", "Markovic", "12311456", "0641532107"));
        add(new Customer(3, "Milan", "Nikoletic", "12333456", "066868190"));
    }

    private final CustomerRepository repository;

    public Customer add(final Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }
}
