package com.springboootacademy.point_of_sale.Service.Impl;

import com.springboootacademy.point_of_sale.DTO.CustomerDTO;
import com.springboootacademy.point_of_sale.DTO.request.CustomerUpdateDTO;
import com.springboootacademy.point_of_sale.Entity.Customer;
import com.springboootacademy.point_of_sale.Repository.CustomerRepo;
import com.springboootacademy.point_of_sale.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        System.out.println("saved data: "+customerDTO);

        Customer customer = new Customer();
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setCustomerAddress(customerDTO.getCustomerAddress());
        customer.setCustomerSalary(customerDTO.getCustomerSalary());
        customer.setContactNumber(customerDTO.getContactNumber());


        customerRepo.save(customer);
        return customerDTO.getCustomerName();


    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
       if(customerRepo.existsById((customerUpdateDTO.getCustomerId()))){

           Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
           customer.setCustomerName(customerUpdateDTO.getCustomerName());
           customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());

           customerRepo.save(customer);
           return customerUpdateDTO.getCustomerName() + " Updated Successful";
       }else {
           throw new RuntimeException("no data found by id");
       }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if(customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO =new CustomerDTO(

                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getCustomerSalary()
            );
            return customerDTO;

        }else {
            throw new RuntimeException("No customer");
        }
    }
}
