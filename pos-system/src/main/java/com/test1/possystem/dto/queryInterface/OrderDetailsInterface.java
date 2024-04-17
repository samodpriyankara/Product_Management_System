package com.test1.possystem.dto.queryInterface;

import java.util.ArrayList;
import java.util.Date;

public interface OrderDetailsInterface {

    String getCustomerName();

    String getCustomerAddress();

    ArrayList getContactNumber();

    Date getDate();

    double getTotal();
}
