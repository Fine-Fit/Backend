package com.finefit.api.service.impl;

import com.finefit.api.domain.entity.TrainerEntity;
import com.finefit.api.domain.model.dto.request.account.LoginDTO;
import com.finefit.api.domain.model.dto.request.account.RegisterDTO;
import com.finefit.api.domain.model.dto.response.ResultResponse;
import com.finefit.api.domain.model.type.FailedResultType;
import com.finefit.api.domain.model.type.SuccessResultType;
import com.finefit.api.domain.repository.AdminRepository;
import com.finefit.api.exception.GlobalException;
import com.finefit.api.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

  private static final Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);
  private final AdminRepository adminRepository;

  @Override
  public ResultResponse adminRegister(RegisterDTO registerDTO) {
    adminRepository.save(RegisterDTO.toTrainerEntity(registerDTO));

    return ResultResponse.of(SuccessResultType.SUCCESS_ADMIN_REGISTER);
  }

  @Override
  public ResultResponse validateId(String trainerId) {
    boolean isDuplicate = adminRepository.existsByTrainerId(trainerId);

    log.info(isDuplicate ? "중복된 아이디" : "사용가능한 아이디");
    return new ResultResponse(SuccessResultType.SUCCESS_VALIDATE_ID, isDuplicate);
  }

  @Override
  public ResultResponse adminLogin(LoginDTO loginDTO) {
    TrainerEntity trainer = adminRepository.findByTrainerId(loginDTO.getTrainerId())
        .orElseThrow(() -> new GlobalException(FailedResultType.FAILED_USER_NOT_FOUND));

    if(!trainer.getPassword().equals(loginDTO.getPassword())) {
      throw new GlobalException(FailedResultType.FAILED_PASSWORD_MISMATCH);
    }

    return ResultResponse.of(SuccessResultType.SUCCESS_ADMIN_LOGIN);
  }
}
