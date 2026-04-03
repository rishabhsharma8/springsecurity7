package com.springsec4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts/api/v1")
public class AccountController {

    @GetMapping("/details")
    public String getAccounts() {
        return "Here are the account details.";
    }
}
