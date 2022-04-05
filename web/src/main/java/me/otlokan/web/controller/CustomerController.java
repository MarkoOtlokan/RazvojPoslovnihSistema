package me.otlokan.web.controller;

import lombok.RequiredArgsConstructor;
import me.otlokan.web.domain.Customer;
import me.otlokan.web.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    private Customer add(@RequestBody final Customer customer) {
        System.out.println("usao zahtev");
        System.out.println(customer);
        return service.add(customer);
    }

    @GetMapping
    private List<Customer> findAll() {
        List<Customer> tmp= service.findAll();
        System.out.println("ispisujem");
        for (Customer t: tmp
             ) {
            System.out.println(t);
        }
        return tmp;
    }


}
