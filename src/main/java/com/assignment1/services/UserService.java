package com.assignment1.services;

import com.assignment1.pojo.User;
import com.assignment1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(String name, String password, String address) {
        User newUser = new User(name, password, address);
        userRepository.save(newUser);

        return newUser;
    }

    public User removeUser(String name, String password, String address) {
        User currentUser = userRepository.findByNameAndPasswordAndAddress(name, password, address);
        userRepository.delete(currentUser);

        return currentUser;
    }

    public Boolean checkIfUserExists(String name, String password, String address) {
        User user = userRepository.findByNameAndPasswordAndAddress(name, password, address);
        if (user != null) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
