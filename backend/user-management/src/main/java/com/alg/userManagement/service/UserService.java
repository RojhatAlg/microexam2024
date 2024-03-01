package com.alg.userManagement.service;

import com.alg.userManagement.model.Users;
import com.alg.userManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Users createUser(Users users) {
        return userRepository.save(users);
    }

    public Users updateUser(Long id, Users usersDetails) {
        Optional<Users> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            Users users = optionalUser.get();
            users.setEmail(usersDetails.getEmail());
            users.setPassword(usersDetails.getPassword());
            users.setRole(usersDetails.getRole());
            return userRepository.save(users);
        } else {
            throw new RuntimeException("Users not found with id: " + id);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
