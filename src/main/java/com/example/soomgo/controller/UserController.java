package com.example.soomgo.controller;

import com.example.soomgo.domain.User;
import com.example.soomgo.exception.SoomgoException;
import com.example.soomgo.model.CreateUserRequset;
import com.example.soomgo.model.GetUserResponse;
import com.example.soomgo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserRepository userRepository;

  @PostMapping
  public void createUser(@RequestBody CreateUserRequset request) {
    userRepository.findByUsername(request.getUsername())
      .ifPresent(user -> {
        throw new SoomgoException("중복된 username");
      });

    userRepository.save(
      User
        .builder()
        .username(request.getUsername())
        .password(request.getPassword())
        .email(request.getEmail())
        .build()
    );
  }

  @GetMapping("/{userId}")
  public GetUserResponse getUser(@PathVariable Long userId) {
    return userRepository.findById(userId)
      .map(user ->
        GetUserResponse
          .builder()
          .id(user.getId())
          .username(user.getUsername())
          .password(user.getPassword())
          .email(user.getEmail())
          .build()
      )
      .orElseThrow(() -> new SoomgoException("사용자 정보 없음"));
  }
}
