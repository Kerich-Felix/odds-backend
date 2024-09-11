package com.ecommerce.odds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.odds.models.Odds;

@Repository
public interface OddsRepo extends JpaRepository<Odds, Long>{

    


}
