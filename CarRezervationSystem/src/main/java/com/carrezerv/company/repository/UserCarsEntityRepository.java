package com.carrezerv.company.repository;

import com.carrezerv.company.entity.UserCarsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCarsEntityRepository extends JpaRepository<UserCarsEntity, Integer> {
    UserCarsEntity findById(int id);
}