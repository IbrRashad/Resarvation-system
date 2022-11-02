package com.carrezerv.company.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rezerved_cars", schema = "car_rs", catalog = "postgres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RezervedCarsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "rez_car_id")
    private int rezCarId;
    @Basic
    @Column(name = "user_id")
    private int userId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RezervedCarsEntity that = (RezervedCarsEntity) o;
        return id == that.id && rezCarId == that.rezCarId && userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rezCarId, userId);
    }
}
