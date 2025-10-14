package com.finefit.api.service;

import com.finefit.api.domain.model.dto.all.CounselDTO;
import com.finefit.api.domain.model.dto.response.ResultResponse;

public interface CounselService {

  ResultResponse writeCounsel(CounselDTO counselDTO);

  ResultResponse readCounsel();
}
