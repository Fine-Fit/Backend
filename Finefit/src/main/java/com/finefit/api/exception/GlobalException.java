package com.finefit.api.exception;


import com.finefit.api.domain.model.type.FailedResultType;
import com.finefit.api.domain.model.dto.response.ResultResponse;
import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException {

  private final ResultResponse resultResponse;

  public GlobalException(FailedResultType failedResultCode) {
    super("");
    this.resultResponse = ResultResponse.of(failedResultCode);
  }

  public GlobalException(ResultResponse resultResponse) {
    super("");
    this.resultResponse = resultResponse;
  }

}
