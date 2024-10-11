package com.example.KiemTraGiuaKi.services;

import com.example.KiemTraGiuaKi.models.User;
import com.example.KiemTraGiuaKi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User updateUser(int id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        user.setAddress(userDetails.getAddress());
        user.setCity(userDetails.getCity());
        user.setCountry(userDetails.getCountry());
        user.setPostalCode(userDetails.getPostalCode());
        return userRepository.save(user);
    }
}
