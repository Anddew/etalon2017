package com.netcracker.project.service;

import java.util.List;

public interface UserService<T> {

    void create(T elem);

    void update(T elem);

    void delete(T elem);

    T findById(int id);

    List<T> findAll();

}
