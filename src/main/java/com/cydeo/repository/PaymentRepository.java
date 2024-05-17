package com.cydeo.repository;

import com.cydeo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

    //Write a native query to find the total sum of all payments made
    @Query(value = "select sum(paid_price) from Payment",nativeQuery = true)
    Integer retrieveSumOfPayment();

    //write a native query to find the average amount paid for all payments
    @Query(value = "select avg (paid_price) from payment",nativeQuery = true)
    Integer retrieveAverageAmount();
}
