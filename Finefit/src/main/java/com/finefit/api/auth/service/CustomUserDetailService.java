package com.finefit.api.auth.service;



import com.finefit.api.domain.entity.TrainerEntity;
import com.finefit.api.domain.model.type.FailedResultType;
import com.finefit.api.domain.repository.AdminRepository;
import com.finefit.api.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

  private final AdminRepository adminRepository;

  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    TrainerEntity user = adminRepository.findById(Long.parseLong(userId))
        .orElseThrow(() -> new GlobalException(FailedResultType.FAILED_USER_NOT_FOUND));

    return org.springframework.security.core.userdetails.User.builder()
        .username(user.getTrainerId())
        .password("")
        .build();
  }
}
