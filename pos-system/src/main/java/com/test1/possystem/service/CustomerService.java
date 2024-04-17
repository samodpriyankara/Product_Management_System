package com.test1.possystem.service;

import com.test1.possystem.dto.CustomerDTO;
import com.test1.possystem.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO getCustomerById(int customerId);

    public String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomersByActiveState(boolean activeState);
}
