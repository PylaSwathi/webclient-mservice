package com.ust.districtsService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="districts")
public class Districts {
    @Id
    private String districtId;
    private String districtName;
    private String population;
    private String stateId;

}
