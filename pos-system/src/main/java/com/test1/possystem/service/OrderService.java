package com.test1.possystem.service;

import com.test1.possystem.dto.paginated.PaginatedResponseOrderDetails;
import com.test1.possystem.dto.request.RequestOrderSaveDTO;

public interface OrderService {
    String saveOrder(RequestOrderSaveDTO requestOrderSaveDTO);


    PaginatedResponseOrderDetails getAllorderDetails(boolean status, int page, int size);
}
