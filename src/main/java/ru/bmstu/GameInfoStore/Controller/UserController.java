package ru.bmstu.GameInfoStore.Controller;

import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import ru.bmstu.GameInfoStore.Entity.User;
import ru.bmstu.GameInfoStore.Service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/api/v1/Users/getAllUsers")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/api/v1/Users/getUser/{login}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public User findUserByLogin(@PathVariable String login){
        return userService.findUserByLogin(login);
    }

    @PutMapping("/api/v1/Users/createUser")
    public String createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping("/api/v1/Users/deleteUser/{login}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteUser(@PathVariable String login){
        return userService.deleteUser(login);
    }

}
