package com.springboootacademy.point_of_sale.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name="customer_id",length =45)
    private int customerId;

    @Column(name ="customer_name",length = 100)
    private String customerName;

    @Column(name ="customer_address",length = 100)
    private String customerAddress;

    @Column(name = "contact_no")
    private  int contactNumber;

    @Column(name="customer_salary")
    private double customerSalary;

    public Customer(int customerId, String customerName, String customerAddress, int contactNumber, double customerSalary) {

    }

    public Customer() {
    }

    public Customer(int customerId, String customerName, int contactNumber, String customerAddress, double customerSalary) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
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

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", contactNumber=" + contactNumber +
                ", customerSalary=" + customerSalary +
                '}';
    }
}
