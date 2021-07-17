package com.example.soomgo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetUserResponse {

  private Long id;
  private String username;
  private String password;
  private String email;
}
