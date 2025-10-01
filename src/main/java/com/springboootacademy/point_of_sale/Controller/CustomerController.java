package com.springboootacademy.point_of_sale.Controller;

import com.springboootacademy.point_of_sale.DTO.CustomerDTO;
import com.springboootacademy.point_of_sale.DTO.request.CustomerUpdateDTO;
import com.springboootacademy.point_of_sale.Service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
        logger.info("Received request to save customer: {}", customerDTO);
        customerService.saveCustomer(customerDTO);
        logger.info("Customer saved successfully: {}", customerDTO);
        return "saved";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        logger.info("Received request to update customer: {}", customerUpdateDTO);
        String message = customerService.updateCustomer(customerUpdateDTO);
        logger.info("Update result: {}", message);
        return message;
    }

    @GetMapping("/search/{id}")
    public CustomerDTO getCustomerById(@PathVariable(value = "id") int customerId){
        logger.info("Searching for customer with id: {}", customerId);
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        logger.info("Found customer: {}", customerDTO);
        return customerDTO;
    }
}
