package com.carrezerv.company.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.carrezerv.company.entity.UserCarsEntity} entity
 */
@Data
public class UserCarsEntityDto implements Serializable {
    private int userId;
    private int id;
    private int carId;
}