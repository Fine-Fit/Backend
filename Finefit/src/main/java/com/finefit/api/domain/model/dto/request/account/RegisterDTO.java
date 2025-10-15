package com.finefit.api.domain.model.dto.request.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.finefit.api.domain.entity.TrainerEntity;
import lombok.Getter;

@Getter
public class RegisterDTO {

  @JsonProperty
  private String trainerId;

  @JsonProperty
  private String password;

  @JsonProperty
  private String trainerName;

  @JsonCreator
  public RegisterDTO(String trainerId, String password, String trainerName) {
    this.trainerId = trainerId;
    this.password = password;
    this.trainerName = trainerName;
  }

  public static TrainerEntity toTrainerEntity(RegisterDTO registerDTO) {
    return TrainerEntity.builder()
        .trainerId(registerDTO.getTrainerId())
        .password(registerDTO.getPassword())
        .trainerName(registerDTO.getTrainerName())
        .build();
  }
}
