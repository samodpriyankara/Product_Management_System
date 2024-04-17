package com.test1.possystem.dto.request;

import com.test1.possystem.entity.Item;
import com.test1.possystem.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDetailsSaveDTO {
    private String itemName;
    private double balanceQty;
    private double amount;
    private int item;
    private int orders;
}
