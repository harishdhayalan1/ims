package com.example.ims.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;
public class PasswordManager {
    public static String encodePassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean isValidPassword(String password, String passwordHash) {
        return BCrypt.checkpw(password, passwordHash);
    }
}
