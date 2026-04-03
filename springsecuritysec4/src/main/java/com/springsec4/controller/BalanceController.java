package com.springsec4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balance/api/v1")
public class BalanceController {

    @GetMapping("/details")
    public String getBalance() {
        return "Here are the balance details.";
    }
}
