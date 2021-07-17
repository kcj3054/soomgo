package com.example.soomgo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Customer {

  @Id
  @Column
  @GeneratedValue
  private Long id;
}
