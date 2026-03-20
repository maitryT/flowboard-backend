package com.demo.flowboard_backend.service;

import com.demo.flowboard_backend.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUserById(Long id);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
