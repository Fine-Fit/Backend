package com.finefit.api.controller;

import com.finefit.api.domain.model.dto.all.CounselDTO;
import com.finefit.api.domain.model.dto.response.ResultResponse;
import com.finefit.api.service.CounselService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/counsel")
@RequiredArgsConstructor
public class CounselController {

  private final CounselService counselService;

  @PostMapping("/write")
  public ResponseEntity<ResultResponse> writeCounsel(@RequestBody CounselDTO counselDTO) {

    ResultResponse response = counselService.writeCounsel(counselDTO);
    return new ResponseEntity<>(response, response.getStatus());

  }

  @GetMapping("/read")
  public ResponseEntity<ResultResponse> readCounsel() {

    ResultResponse response = counselService.readCounsel();
    return new ResponseEntity<>(response, response.getStatus());
  }
}
