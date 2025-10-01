package com.springboootacademy.point_of_sale.Service.Impl;

import com.springboootacademy.point_of_sale.DTO.CustomerDTO;
import com.springboootacademy.point_of_sale.DTO.request.CustomerUpdateDTO;
import com.springboootacademy.point_of_sale.Entity.Customer;
import com.springboootacademy.point_of_sale.Repository.CustomerRepo;
import com.springboootacademy.point_of_sale.Service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceIMPL.class);

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        logger.info("Saving customer: {}", customerDTO);

        Customer customer = new Customer();
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setCustomerAddress(customerDTO.getCustomerAddress());
        customer.setCustomerSalary(customerDTO.getCustomerSalary());
        customer.setContactNumber(customerDTO.getContactNumber());

        customerRepo.save(customer);
        logger.info("Customer saved successfully with ID: {}", customer.getCustomerId());

        return customerDTO.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            logger.info("Updating customer with ID: {}", customerUpdateDTO.getCustomerId());

            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());

            customerRepo.save(customer);
            logger.info("Customer updated successfully: {}", customerUpdateDTO.getCustomerId());

            return customerUpdateDTO.getCustomerName() + " Updated Successfully";
        } else {
            logger.warn("No customer found with ID: {}", customerUpdateDTO.getCustomerId());
            throw new RuntimeException("No data found by ID");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            logger.info("Fetching customer with ID: {}", customerId);

            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getCustomerSalary()
            );

            logger.info("Customer fetched: {}", customerDTO);
            return customerDTO;
        } else {
            logger.warn("No customer found with ID: {}", customerId);
            throw new RuntimeException("No customer found");
        }
    }
}
