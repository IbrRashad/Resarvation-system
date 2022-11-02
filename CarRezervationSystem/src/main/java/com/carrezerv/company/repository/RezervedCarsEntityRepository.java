package com.carrezerv.company.repository;

import com.carrezerv.company.entity.RezervedCarsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezervedCarsEntityRepository extends JpaRepository<RezervedCarsEntity, Integer> {
    RezervedCarsEntity findById(int id);
    RezervedCarsEntity findByRezCarId(int id);
}