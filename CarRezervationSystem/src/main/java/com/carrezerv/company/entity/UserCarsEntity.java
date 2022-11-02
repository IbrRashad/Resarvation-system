package com.carrezerv.company.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_cars", schema = "car_rs", catalog = "postgres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCarsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "car_id")
    private int carId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCarsEntity that = (UserCarsEntity) o;
        return id == that.id && userId == that.userId && carId == that.carId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, carId);
    }
}
