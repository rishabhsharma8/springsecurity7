package com.springsec4.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notices/api/v1")
public class NoticesController {

    @RequestMapping("/details")
    public String getDetails() {
        return "Here are the notice details.";
    }
}
