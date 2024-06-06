package ru.bmstu.GameInfoStore.Service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bmstu.GameInfoStore.Entity.User;
import ru.bmstu.GameInfoStore.Repository.UserRepository;
import ru.bmstu.GameInfoStore.Service.UserService;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public User findUserByLogin(String login) {
        return repository.findUserByLogin(login);
    }

    @Override
    public String createUser(User user) {
        if(findUserByLogin(user.getLogin()) != null){
            return "Пользователь с таким логином уже существует.";
        }
        repository.save(user);
        return "Пользователь был успешно создан.";
    }

    @Override
    public String updateUser(User user) {
        if(findUserByLogin(user.getLogin()) == null){
            return "Пользователя с таким логином не существует.";
        }
        repository.save(user);
        return "Данные о пользователе были успешно обновлены.";
    }

    @Override
    public String deleteUser(String login) {
        if(findUserByLogin(login) == null){
            return "Пользователя с таким логином не существует.";
        }
        repository.deleteById(login);
        return "Данные о пользователе были успешно удалены.";
    }
}
