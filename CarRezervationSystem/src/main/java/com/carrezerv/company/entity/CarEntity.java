package com.carrezerv.company.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "car", schema = "car_rs", catalog = "postgres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "brand")
    private String brand;
    @Basic
    @Column(name = "model")
    private String model;
    @Basic
    @Column(name = "rez_price")
    private int rezPrice;
    @Basic
    @Column(name = "color")
    private String color;
    @Basic
    @Column(name = "e_date")
    private Date eDate;
    @Basic
    @Column(name = "segment")
    private String segment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEntity carEntity = (CarEntity) o;
        return id == carEntity.id && rezPrice == carEntity.rezPrice && Objects.equals(brand, carEntity.brand) && Objects.equals(model, carEntity.model) && Objects.equals(color, carEntity.color) && Objects.equals(eDate, carEntity.eDate) && Objects.equals(segment, carEntity.segment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, rezPrice, color, eDate, segment);
    }
}
