package com.springsec4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts/api/v1")
public class ContactsController {


    @GetMapping("/details")
    public String getDetails() {
        return "Here are the contact details.";
    }
}
