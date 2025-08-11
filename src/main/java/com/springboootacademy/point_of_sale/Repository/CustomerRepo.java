package com.springboootacademy.point_of_sale.Repository;

import com.springboootacademy.point_of_sale.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CustomerRepo  extends JpaRepository<Customer,Integer> {
}
