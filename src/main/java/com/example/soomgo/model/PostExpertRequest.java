package com.example.soomgo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostExpertRequest {

  private Long userId;
  private String targetService;
  private String simpleContents;
  private Boolean authorized;
  private String location;
  private Integer availableDistance;
  private String possibleContactTime;
  private String paymentMethod;
  private String bankAccount;
  private Integer career;
  private String detail;
}
