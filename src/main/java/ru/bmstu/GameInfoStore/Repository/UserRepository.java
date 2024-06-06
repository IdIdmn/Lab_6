package ru.bmstu.GameInfoStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bmstu.GameInfoStore.Entity.User;

public interface UserRepository extends JpaRepository<User, String> {

    User findUserByLogin(String login);

}
