package com.example.ims.dao;

import com.example.ims.entities.User;
import com.example.ims.repositories.UserRepository;

import java.util.Optional;

public class UserDao implements Dao<User> {
    private UserRepository userRepository;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
