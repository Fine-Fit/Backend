package com.finefit.api.exception;


import com.finefit.api.domain.model.dto.response.ResultResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


  @ExceptionHandler(GlobalException.class)
  public ResponseEntity<ResultResponse> handleGlobalException(GlobalException ex) {
    ResultResponse resultResponse = ex.getResultResponse();
    return new ResponseEntity<>(resultResponse, resultResponse.getStatus());
  }
}
