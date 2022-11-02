package com.carrezerv.company.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.carrezerv.company.entity.RezervedCarsEntity} entity
 */
@Data
public class RezervedCarsEntityDto implements Serializable {
    private int id;
    private int rezCarId;
    private int userId;
}