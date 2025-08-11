package com.springboootacademy.point_of_sale.Controller;

import com.springboootacademy.point_of_sale.DTO.CustomerDTO;
import com.springboootacademy.point_of_sale.DTO.request.CustomerUpdateDTO;
import com.springboootacademy.point_of_sale.Service.CustomerService;
import com.springboootacademy.point_of_sale.Service.Impl.CustomerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {

        customerService.saveCustomer(customerDTO);
        return "saved";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
            String massage = customerService.updateCustomer(customerUpdateDTO);
            return massage;
    }

    @GetMapping(
            path= "/search",
            params="id")

    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId){
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }
}
