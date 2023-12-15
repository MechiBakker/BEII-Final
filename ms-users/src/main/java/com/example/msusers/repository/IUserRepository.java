package com.example.msusers.repository;

import com.example.msusers.domain.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();
    List<User> findUserById(String id);

}
