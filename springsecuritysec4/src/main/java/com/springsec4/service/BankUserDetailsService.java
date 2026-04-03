package com.springsec4.service;

import com.springsec4.entity.Customer;
import com.springsec4.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(username).orElseThrow( () -> new UsernameNotFoundException("User not found with email:"+username));
        return User.builder()
                .username(customer.getEmail())
                .password(customer.getPassword())
                .authorities(customer.getRole().toUpperCase())
                .build();
    }
}
