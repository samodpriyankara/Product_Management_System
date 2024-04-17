package com.test1.possystem.dto.request;

import com.test1.possystem.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;


import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class ItemSaveRequestDTO {


    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;


}
