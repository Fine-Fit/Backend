package com.finefit.api.domain.repository;

import com.finefit.api.domain.entity.TrainerEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<TrainerEntity, Long> {

  boolean existsByTrainerId(String trainerId);

  Optional<TrainerEntity> findByTrainerId(String trainerId);
}
