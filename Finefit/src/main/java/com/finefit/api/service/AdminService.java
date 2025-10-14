package com.finefit.api.service;

import com.finefit.api.domain.model.dto.request.account.LoginDTO;
import com.finefit.api.domain.model.dto.response.ResultResponse;
import com.finefit.api.domain.model.dto.request.account.RegisterDTO;

public interface AdminService {

  ResultResponse adminRegister(RegisterDTO registerDTO);

  ResultResponse validateId(String id);

  ResultResponse adminLogin(LoginDTO loginDTO);
}
