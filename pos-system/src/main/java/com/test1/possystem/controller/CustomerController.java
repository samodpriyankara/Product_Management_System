package com.test1.possystem.controller;

import com.test1.possystem.dto.CustomerDTO;
import com.test1.possystem.dto.request.CustomerUpdateDTO;
import com.test1.possystem.service.CustomerService;
import com.test1.possystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

//    @PostMapping(path = "/save" )
//    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
//
//        String msg = customerService.saveCustomer(customerDTO);
//        return msg;
//
//    }
//---------------------------------------------------------------------
//    @PostMapping(path = "/save" )
//    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO){
//
//        String msg = customerService.saveCustomer(customerDTO);
//        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
//               new StandardResponse(202,"Successful",msg), HttpStatus.CREATED
//        );
//        return responseEntity;

    // }

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO) {

        String msg = customerService.saveCustomer(customerDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(202, "Successful", msg),
                HttpStatus.CREATED
        );


    }

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        String msg = customerService.updateCustomer(customerUpdateDTO);

        return msg;

    }

    @GetMapping(
            path = "get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId) {
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }

//    @GetMapping(path = "/get-all-customer")
//    public List<CustomerDTO> getAllCustomers() {
//
//        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
//        return allCustomers;
//    }

    @GetMapping(path = "/get-all-customer")
    public ResponseEntity<StandardResponse> getAllCustomers() {

        List<CustomerDTO> allCustomers = customerService.getAllCustomers();

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",allCustomers),
                HttpStatus.OK
        );
    }

    @DeleteMapping(
            path = "/delete/{id}"
    )
    public String deleteCustomer(@PathVariable(value = "id") int customerId) {

        String msg = customerService.deleteCustomer(customerId);
        return msg;
    }

    @GetMapping(path = "/get-all-customer-by-ative-state/{status}")
    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable(value = "status") boolean activeState) {

        List<CustomerDTO> allCustomersBystate = customerService.getAllCustomersByActiveState(activeState);
        return allCustomersBystate;
    }


}
