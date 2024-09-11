package com.ecommerce.odds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.odds.models.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long>{

    


}
