package org.ieee.iot.domain;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WhetherData extends BaseEntity{

    private Integer temp;
    private Integer humidity;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        WhetherData that = (WhetherData) o;
        return super.id != null && Objects.equals(id, that.id);
    }

}
