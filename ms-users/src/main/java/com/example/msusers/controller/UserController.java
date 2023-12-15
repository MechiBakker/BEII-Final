package com.example.msusers.controller;

import com.example.msusers.domain.Bill;
import com.example.msusers.domain.User;
import com.example.msusers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll(){

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable String id) {
        return ResponseEntity.ok(service.findUserById(id));
    }

    @GetMapping("/{userId}/bills")
    public ResponseEntity<List<Bill>> findBillByUser(@PathVariable String id) {
        return ResponseEntity.ok(service.findByUser(id));
    }
}
