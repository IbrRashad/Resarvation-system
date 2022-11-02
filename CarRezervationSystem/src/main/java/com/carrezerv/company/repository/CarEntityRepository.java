package com.carrezerv.company.repository;

import com.carrezerv.company.entity.CarEntity;
import com.carrezerv.company.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarEntityRepository extends JpaRepository<CarEntity, Integer> {
    CarEntity findById(int id);
}