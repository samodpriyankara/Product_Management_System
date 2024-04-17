package com.test1.possystem.dto.request;

import com.test1.possystem.entity.Customer;
import com.test1.possystem.entity.OdereDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderSaveDTO {

    private int customer;
    private Date date;
    private double total;
    private List<RequestOrderDetailsSaveDTO> odereDetails;
}
