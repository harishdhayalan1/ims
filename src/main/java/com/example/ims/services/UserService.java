package com.example.ims.services;

import com.example.ims.dao.Dao;
import com.example.ims.dao.UserDao;
import com.example.ims.entities.User;
import com.example.ims.utils.PasswordManager;

import java.util.Optional;

public class UserService {
    Dao<User> userDao;

    public UserService() {
        userDao = new UserDao();
    }
    public void createUser(String name, String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPasswordHash(PasswordManager.encodePassword(password));
        userDao.create(user);
    }

    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public boolean isValidPassword(User user, String password) {
        return PasswordManager.isValidPassword(password, user.getPasswordHash());
    }

    public void sendForgetPasswordEmail(String email) {

    }
}
