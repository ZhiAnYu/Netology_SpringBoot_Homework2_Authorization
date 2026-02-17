package ru.netology.SpringBootHomework2.repository;

import org.springframework.stereotype.Repository;
import ru.netology.SpringBootHomework2.model.Authorities;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();

        // Эмуляция проверки данных в БД
        // Для примера: логин admin, пароль 123 имеют все права
        if ("admin".equals(user) && "123".equals(password)) {
            authorities.add(Authorities.READ);
            authorities.add(Authorities.WRITE);
            authorities.add(Authorities.DELETE);
            return authorities;
        }
        // Для примера: логин user, пароль 123 имеет только чтение
        else if ("user".equals(user) && "123".equals(password)) {
            authorities.add(Authorities.READ);
            return authorities;
        }
        // Если пользователь не найден или пароль неверный — возвращаем пустой список
        // Это приведет к выбросу UnauthorizedUser в сервисе
        return authorities;
    }
}
