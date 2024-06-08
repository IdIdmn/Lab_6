package ru.bmstu.GameInfoStore.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.bmstu.GameInfoStore.Entity.User;
import ru.bmstu.GameInfoStore.Repository.UserRepository;
import ru.bmstu.GameInfoStore.Config.MyUserDetails;


import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = repository.findUserByLogin(login);
        return new MyUserDetails(user);
    }
}
