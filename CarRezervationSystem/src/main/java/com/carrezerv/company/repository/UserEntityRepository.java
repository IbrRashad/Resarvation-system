package com.carrezerv.company.repository;

import com.carrezerv.company.dto.UserEntityDto;
import com.carrezerv.company.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findById(int id);
}