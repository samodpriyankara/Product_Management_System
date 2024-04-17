package com.test1.possystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseOrderDTO {

    //customer
    private String customerName;
    private String customerAddress;
    private ArrayList contactNumber;

    //order
    private Date date;
    private double total;
}
