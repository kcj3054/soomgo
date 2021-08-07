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
public class Expert {

  @Id
  @Column
  @GeneratedValue
  private Long id;

  @Column
  private Long userId;

  @Column
  private String targetService;

  @Column
  private String simpleContents;

  @Column
  private Boolean authorized;

  @Column
  private String location;

  @Column
  private Integer availableDistance;

  @Column
  private String possibleContactTime;

  @Column
  private String paymentMethod;

  @Column
  private String bankAccount;

  @Column
  private Integer career;

  @Column
  private String detail;
}
