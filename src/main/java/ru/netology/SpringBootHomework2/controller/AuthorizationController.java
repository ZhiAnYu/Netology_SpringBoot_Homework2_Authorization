package ru.netology.SpringBootHomework2.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.SpringBootHomework2.model.AuthUser;
import ru.netology.SpringBootHomework2.model.Authorities;
import ru.netology.SpringBootHomework2.model.User;
import ru.netology.SpringBootHomework2.service.AuthorizationService;

import java.util.List;

@RestController
@Validated
public class AuthorizationController {

    @Autowired
    private AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@AuthUser @Valid User user) {
        return service.getAuthorities(user);
    }
}