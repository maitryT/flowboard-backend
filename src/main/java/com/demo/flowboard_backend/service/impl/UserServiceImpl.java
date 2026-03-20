package com.demo.flowboard_backend.service.impl;

import com.demo.flowboard_backend.model.User;
import com.demo.flowboard_backend.repository.UserRepository;
import com.demo.flowboard_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


   @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("User already exist");
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if(existingUser != null){
            existingUser.setId(user.getId());
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setType(user.getType());
            return userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
