package com.springsec2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards/api/v1")
public class CardsController {

    @GetMapping("/details")
    public String getCards() {
        return "Here are the card details.";
    }
}
