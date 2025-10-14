package com.finefit.api.domain.repository;

import com.finefit.api.domain.entity.CounselEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounselRepository extends JpaRepository<CounselEntity, Long> {

}
