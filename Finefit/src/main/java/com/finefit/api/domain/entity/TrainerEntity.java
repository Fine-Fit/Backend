package com.finefit.api.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Trainer")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class TrainerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String trainerName;

  @Column(nullable = false)
  private String trainerId;

  @Column(nullable = false)
  private String password;
}
