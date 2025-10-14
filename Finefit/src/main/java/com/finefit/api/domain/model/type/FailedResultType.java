package com.finefit.api.domain.model.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum FailedResultType {
  FAILED_USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "존재하지 않은 사용자 입니다."),
  FAILED_PASSWORD_MISMATCH(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다."),
  ;

  private final HttpStatus status;
  private final String message;
}
