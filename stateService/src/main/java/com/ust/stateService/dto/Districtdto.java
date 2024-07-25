package com.ust.stateService.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Districtdto {
    private String districtId;
    private String districtName;
    private String population;
    private String stateId;
}
