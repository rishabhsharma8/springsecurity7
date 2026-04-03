package com.springsec4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain customSecurityFilterChain(HttpSecurity http) {
        http.authorizeHttpRequests(r -> r.requestMatchers("/balance/**","/cards/**","/loans/api/v1/details","/accounts/**").authenticated()
                .requestMatchers("/contacts/**","/notices/**","/customer/api/v1/register").permitAll());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());
        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails adminUser = User.withUsername("rishabh")
//                .password("{noop}rishabh12345")
//                .authorities("read","write")
//                .build();
//
//        UserDetails normalUser = User.withUsername("mohit")
//                .password("{bcrypt}$2a$12$2acCjdotaMutD6R4kf9xfevlrFWsCkW9jaWRHP2urwFW2KOKqgUY2")  //mohit
//                .authorities("read")
//                .build();
//
//        return new InMemoryUserDetailsManager(adminUser,normalUser);
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource)
//    {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker()
    {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }

}
