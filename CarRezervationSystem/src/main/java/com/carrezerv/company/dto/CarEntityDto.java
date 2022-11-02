package com.carrezerv.company.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * A DTO for the {@link com.carrezerv.company.entity.CarEntity} entity
 */
@Data
public class CarEntityDto implements Serializable {
    private int id;
    private String brand;
    private String model;
    private int rezPrice;
    private String color;
    private Date eDate;
    private String segment;
}