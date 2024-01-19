package com.example.ims.dao;

import java.util.Optional;

public interface Dao<T> {
    void create(T t);

    Optional<T> findByEmail(String email);

}
