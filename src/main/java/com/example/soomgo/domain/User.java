package com.example.soomgo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Data
public class User {

  @Id
  @Column
  @GeneratedValue
  private Long id;

  @Column
  private String username;

  @Column
  private String password;

  @Column
  private String email;

}
