package com.example.sql_exercise_day2.service;
import com.example.sql_exercise_day2.repository.UserRepository;
import com.example.sql_exercise_day2.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public void addUser(User user) {
        userRepository.save(user);
    }
    public void updateUser(User user, Integer id) {
        User old=userRepository.getReferenceById(id);
        old.setUsername(user.getUsername());
        old.setPassword(user.getPassword());
        old.setRole(user.getRole());
        userRepository.save(old);
    }
    public void deleteUser(Integer id) {
        User user=userRepository.getReferenceById(id);
        userRepository.delete(user);
    }
}