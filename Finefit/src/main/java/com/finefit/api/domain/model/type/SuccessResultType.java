package com.finefit.api.domain.model.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessResultType {
  SUCCESS_ADMIN_REGISTER(HttpStatus.OK, "관리자 회원가입 성공"),
  SUCCESS_VALIDATE_ID(HttpStatus.OK, "아이디 중복 체크 성공"),
  SUCCESS_ADMIN_LOGIN(HttpStatus.OK, "관리자 로그인 성공"),
  SUCCESS_WRITE_COUNSEL(HttpStatus.OK, "설문지 작성 성공"),
  SUCCESS_READ_COUNSEL(HttpStatus.OK, "설문지 조회 성공"),
  ;

  private final HttpStatus status;
  private final String message;
}
