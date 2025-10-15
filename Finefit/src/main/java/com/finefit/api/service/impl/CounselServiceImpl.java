package com.finefit.api.service.impl;

import com.finefit.api.domain.entity.CounselEntity;
import com.finefit.api.domain.model.dto.all.CounselDTO;
import com.finefit.api.domain.model.dto.response.ResultResponse;
import com.finefit.api.domain.model.type.SuccessResultType;
import com.finefit.api.domain.repository.CounselRepository;
import com.finefit.api.service.CounselService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CounselServiceImpl implements CounselService {

  private final CounselRepository counselRepository;

  @Override
  public ResultResponse writeCounsel(CounselDTO counselDTO) {
    CounselEntity counsel = CounselDTO.toCounselEntity(counselDTO);

    counselRepository.save(counsel);

    return ResultResponse.of(SuccessResultType.SUCCESS_ADMIN_REGISTER);
  }

  @Override
  public ResultResponse readCounsel() {
    List<CounselDTO> counselEntityList = CounselDTO.toCounselDTO(counselRepository.findAll());


    return new ResultResponse(SuccessResultType.SUCCESS_ADMIN_REGISTER, counselEntityList);
  }
}
