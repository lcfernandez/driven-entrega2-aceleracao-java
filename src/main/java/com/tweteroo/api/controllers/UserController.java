package com.tweteroo.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
  final UserRepository userRepository;

  UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping
  public ResponseEntity<Object> createUser(@RequestBody @Valid UserDTO body) {
    UserModel user = new UserModel(body);
    userRepository.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }
}
