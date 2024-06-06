package ru.bmstu.GameInfoStore.Service;

import ru.bmstu.GameInfoStore.Entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User findUserByLogin(String login);

    String createUser(User user);

    String updateUser(User user);

    String deleteUser(String login);

}
