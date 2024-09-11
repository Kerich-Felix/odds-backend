package com.ecommerce.odds.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.ecommerce.odds.models.Odds;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OddsDTO {

    private int statusCode;
    private String message;
    private String error;
    private String homeTeam;
    private String awayTeam;
    private float oods;
    private LocalDateTime time;
    private String description;
    private Odds odds;
    private List<Odds> oodsList;

}
