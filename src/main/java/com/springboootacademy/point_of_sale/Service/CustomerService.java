package com.springboootacademy.point_of_sale.Service;

import com.springboootacademy.point_of_sale.DTO.CustomerDTO;
import com.springboootacademy.point_of_sale.DTO.request.CustomerUpdateDTO;

public interface CustomerService {
    String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);
}
