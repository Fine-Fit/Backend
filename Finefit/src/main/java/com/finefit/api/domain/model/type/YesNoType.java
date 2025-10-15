package com.finefit.api.domain.model.type;


import lombok.Getter;

/** 예/아니오 */

@Getter
public enum YesNoType {
  YES("예"),
  NO("아니오");

  private final String description;

  YesNoType(String description) {
    this.description = description;
  }

}
