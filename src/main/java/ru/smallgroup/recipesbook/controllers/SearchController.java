package ru.smallgroup.recipesbook.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @GetMapping("/")
    public String index() {
        return "Home Page";
    }

}
