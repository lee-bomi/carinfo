package com.zerobase.carinfo.service;

import lombok.Data;

@Data
public class CarInputDto {
    private String modelName;
    private Long companyId;
    private Integer passengerCapacity;
}
