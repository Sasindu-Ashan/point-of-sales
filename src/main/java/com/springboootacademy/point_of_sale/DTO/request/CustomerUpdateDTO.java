package com.springboootacademy.point_of_sale.DTO.request;

public class CustomerUpdateDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;

    public CustomerUpdateDTO() {
    }

    public CustomerUpdateDTO(String customerName, int customerId, String customerAddress) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.customerAddress = customerAddress;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "CustomerUpdateDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}

