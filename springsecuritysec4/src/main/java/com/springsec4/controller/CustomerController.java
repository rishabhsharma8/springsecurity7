package com.springsec4.controller;

import com.springsec4.entity.Customer;
import com.springsec4.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authentication.password.CompromisedPasswordDecision;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/customer/api/v1")
@RequiredArgsConstructor
public class CustomerController {

    private final CompromisedPasswordChecker compromisedPasswordChecker;
    private final PasswordEncoder passwordEncoder;
    private final CustomerRepository customerRepository;

    @PostMapping(value = "/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
        CompromisedPasswordDecision compromisedPasswordDecision = compromisedPasswordChecker.check(customer.getPassword());
        if(compromisedPasswordDecision.isCompromised())
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The porvided password is compromised, please provide a strong password.");
        }

        Optional<Customer> existingCustomer = customerRepository.findByEmail(customer.getEmail());
        if(existingCustomer.isPresent())
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer with email " + customer.getEmail() + " already exists.");
        }

        try{
            String hashedPassword = passwordEncoder.encode(customer.getPassword());
            customer.setPassword(hashedPassword);
            Customer savedCustomer = customerRepository.save(customer);
            if(savedCustomer.getId() > 0 )
                return ResponseEntity.status(HttpStatus.CREATED).body("Given customer details are successfully registered");
            else
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer registration failed.");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register customer.");
        }

    }
}
