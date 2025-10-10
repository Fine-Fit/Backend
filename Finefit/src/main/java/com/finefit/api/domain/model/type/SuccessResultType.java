package com.finefit.api.domain.model.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessResultType {
  SUCCESS_ADMIN_REGISTER(HttpStatus.OK, "관리자 회원가입 성공"),
  ;

  private final HttpStatus status;
  private final String message;
}
