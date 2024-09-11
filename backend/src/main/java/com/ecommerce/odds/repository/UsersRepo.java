package com.ecommerce.odds.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.odds.models.OurUsers;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<OurUsers, Integer> {

    Optional<OurUsers> findByEmail(String email);

    
}