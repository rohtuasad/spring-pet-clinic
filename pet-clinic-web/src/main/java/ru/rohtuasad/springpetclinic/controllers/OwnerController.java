package ru.rohtuasad.springpetclinic.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

// Alternative way to map requests
@RequestMapping("/owners")
@Component
public class OwnerController {
    @RequestMapping({"", "/index", "/index.html"})
    public String listOwners() {
        return "owners/index";
    }
}
