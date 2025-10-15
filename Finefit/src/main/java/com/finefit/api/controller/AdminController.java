package com.finefit.api.controller;


import com.finefit.api.domain.model.dto.request.account.LoginDTO;
import com.finefit.api.domain.model.dto.response.ResultResponse;
import com.finefit.api.domain.model.dto.request.account.RegisterDTO;
import com.finefit.api.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

  private final AdminService adminService;

  @PostMapping("/auth/register")
  public ResponseEntity<ResultResponse> adminRegister(@RequestBody RegisterDTO registerDTO) {

    log.info("====================================");
    log.info("관리자 회원가입 시작");
    log.info("트레이너 명 : {}", registerDTO.getTrainerName());

    ResultResponse response = adminService.adminRegister(registerDTO);
    return new ResponseEntity<>(response, response.getStatus());
  }

  @GetMapping("/auth/validate-id")
  public ResponseEntity<ResultResponse> adminValidateId(@RequestParam("trainerId") String trainerId) {

    log.info("====================================");
    log.info("관리자 아이디 중복 검증 시작");
    log.info("검증할 ID : {}", trainerId);

    ResultResponse response = adminService.validateId(trainerId);
    return new ResponseEntity<>(response, response.getStatus());
  }

  @PostMapping("/auth/login")
  public ResponseEntity<ResultResponse> adminLogin(@RequestBody LoginDTO loginDTO) {

    ResultResponse response = adminService.adminLogin(loginDTO);
    return new ResponseEntity<>(response, response.getStatus());
  }

}
