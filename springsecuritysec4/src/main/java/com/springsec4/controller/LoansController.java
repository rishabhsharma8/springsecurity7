package com.springsec4.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans/api/v1")
public class LoansController {

        @RequestMapping("/details")
        public String getLoans() {
            return "Here are the loan details.";
        }
}
