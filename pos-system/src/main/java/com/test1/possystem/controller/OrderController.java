package com.test1.possystem.controller;

import com.test1.possystem.dto.paginated.PaginatedResponseOrderDetails;
import com.test1.possystem.dto.request.ItemSaveRequestDTO;
import com.test1.possystem.dto.request.RequestOrderSaveDTO;
import com.test1.possystem.service.OrderService;
import com.test1.possystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/order")

public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO) {

        String id = orderService.saveOrder(requestOrderSaveDTO);

        System.out.println(requestOrderSaveDTO);

        return new ResponseEntity<>(new StandardResponse(200, "successful", id), HttpStatus.CREATED);
    }

    @GetMapping(
            path = {"/get-details"},
            params = {"state", "page", "size"}
    )
    public ResponseEntity<StandardResponse> getAllorderDetails(
            @RequestParam(value = "state") String activeSatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        PaginatedResponseOrderDetails p = null;
        if (activeSatus.equalsIgnoreCase("active") | activeSatus.equalsIgnoreCase("inactive")) {
            boolean status = activeSatus.equalsIgnoreCase("active") ? true : false;
            p = orderService.getAllorderDetails(status, page, size);
        }
        return new ResponseEntity<StandardResponse>(new StandardResponse(200, "Success", p), HttpStatus.OK);

    }


}
