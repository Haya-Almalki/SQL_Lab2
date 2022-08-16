package com.example.sql_exercise_day2.controller;
import com.example.sql_exercise_day2.model.User;
import com.example.sql_exercise_day2.dto.ApiResponse;
import com.example.sql_exercise_day2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userSrvice;

    @GetMapping
    public ResponseEntity<List> getUsers(){
        List<User> users=userSrvice.getUsers();
        return ResponseEntity.status(200).body(users);
    }
    @PostMapping
    public ResponseEntity<ApiResponse> addUser(@RequestBody @Valid User user){
        userSrvice.addUser(user);
        return ResponseEntity.status(201).body(new ApiResponse("User added",201));
    }
    @PutMapping("{id}")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody @Valid User user,@PathVariable Integer id){
        userSrvice.updateUser(user,id);
        return ResponseEntity.status(201).body(new ApiResponse("User updated",201));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id){
        userSrvice.deleteUser(id);
        return ResponseEntity.status(201).body(new ApiResponse("User deleted",201));
    }
}
