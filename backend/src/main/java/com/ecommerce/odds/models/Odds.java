package com.ecommerce.odds.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "odds_details")
public class Odds {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String homeTeam;
    private String awayTeam;
    private float oods;
    private LocalDateTime time;
    private String description;



}
