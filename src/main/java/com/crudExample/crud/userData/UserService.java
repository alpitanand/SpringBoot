package com.crudExample.crud.userData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserByID(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void findByIdAndUpdate(int id, String name) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return;
        user.setName(name);
        userRepository.save(user);
    }

}
