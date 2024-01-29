package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
  final UserRepository userRepository;

  UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping
  public void createUser(@RequestBody String body) {
    System.out.println(body);
  }
}
