package com.test1.possystem.service.impl;

import com.test1.possystem.dto.paginated.PaginatedResponseOrderDetails;
import com.test1.possystem.dto.queryInterface.OrderDetailsInterface;
import com.test1.possystem.dto.request.RequestOrderSaveDTO;
import com.test1.possystem.dto.response.ResponseOrderDTO;
import com.test1.possystem.entity.OdereDetails;
import com.test1.possystem.entity.Orders;
import com.test1.possystem.repo.CustomerRepo;
import com.test1.possystem.repo.ItemRepo;
import com.test1.possystem.repo.OrderDetailsRepo;
import com.test1.possystem.repo.OrderRepo;
import com.test1.possystem.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Override
    @Transactional
    public String saveOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Orders orders = new Orders(
                customerRepo.getReferenceById(requestOrderSaveDTO.getCustomer()),
                requestOrderSaveDTO.getDate(),
                requestOrderSaveDTO.getTotal()
        );
        orderRepo.save(orders);
        if (orderRepo.existsById(orders.getOrderId())) {
            List<OdereDetails> odereDetailsList = modelMapper.map(requestOrderSaveDTO.getOdereDetails(), new TypeToken<List<OdereDetails>>() {
            }.getType());

//            for (OdereDetails odereDetails: odereDetailsList) {
//                odereDetails.setOrders(orders);
//                odereDetails.setItem(itemRepo.getReferenceById(odereDetails.getItem().getItemId()));
//
//            }

            for (int i = 0; odereDetailsList.size() > i; i++) {
                odereDetailsList.get(i).setOrders(orders);
                odereDetailsList.get(i).setItem(itemRepo.getReferenceById(requestOrderSaveDTO.getOdereDetails().get(i).getItem()));
            }
            if (odereDetailsList.size() > 0) {
                orderDetailsRepo.saveAll(odereDetailsList);
            }
            return "Saved";
        } else {
            throw new RuntimeException("Not saved");
        }

    }

    @Override
    public PaginatedResponseOrderDetails getAllorderDetails(boolean status, int page, int size) {
        List<OrderDetailsInterface> orderDTOS = orderRepo.getAllOrderDetails(status, PageRequest.of(page, size));

        List<ResponseOrderDTO> list = new ArrayList<>();
        for (OrderDetailsInterface o : orderDTOS) {
            ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO(
                    o.getCustomerName(),
                    o.getCustomerAddress(),
                    o.getContactNumber(),
                    o.getDate(),
                    o.getTotal()
            );
            list.add(responseOrderDTO);

        }
        PaginatedResponseOrderDetails paginatedResponseOrderDetails = new PaginatedResponseOrderDetails(
                list,
                orderRepo.countAllOrderDetails(status)

        );

        return paginatedResponseOrderDetails;
    }


}
