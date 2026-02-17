package ru.netology.SpringBootHomework2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.SpringBootHomework2.exception.InvalidCredentials;
import ru.netology.SpringBootHomework2.exception.UnauthorizedUser;
import ru.netology.SpringBootHomework2.model.Authorities;
import ru.netology.SpringBootHomework2.model.User;
import ru.netology.SpringBootHomework2.repository.UserRepository;

import java.util.List;

@Service

public class AuthorizationService {
    @Autowired
    UserRepository userRepository;

    public List<Authorities> getAuthorities(User user) {
        if (user == null || isEmpty(user.getUser()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }

        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getUser(), user.getPassword());
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUser());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
