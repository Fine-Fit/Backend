package com.finefit.api.domain.model.dto.request.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LoginDTO {

  @JsonProperty
  private String trainerId;

  @JsonProperty
  private String password;

  @JsonCreator
  public LoginDTO(@JsonProperty("trainerId") String trainerId, @JsonProperty("password") String password) {
    this.trainerId = trainerId;
    this.password = password;
  }

}
