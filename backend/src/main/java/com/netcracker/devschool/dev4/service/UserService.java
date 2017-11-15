package com.netcracker.devschool.dev4.service;

import java.util.List;

public interface UserService<T> {

    void create(T elem);

    void update(T elem);

    void delete(T elem);

    T findById(int id);

    List<T> findAll();

}
