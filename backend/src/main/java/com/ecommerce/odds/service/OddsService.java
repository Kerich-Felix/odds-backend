package com.ecommerce.odds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.odds.dtos.OddsDTO;
import com.ecommerce.odds.models.Odds;
import com.ecommerce.odds.repository.OddsRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class OddsService {
    @Autowired
    private final OddsRepo oddsRepo;

    public OddsDTO addNewOdds(OddsDTO oddsDTO){
        OddsDTO dto = new OddsDTO();
        try{
            Odds odds = new Odds();
            odds.setHomeTeam(oddsDTO.getHomeTeam());
            odds.setAwayTeam(oddsDTO.getAwayTeam());
            odds.setOods(oddsDTO.getOods());
            odds.setTime(oddsDTO.getTime());
            odds.setDescription(oddsDTO.getDescription());

            Odds savedOdds = oddsRepo.save(odds);

            if(savedOdds.getId() > 0){
                dto.setOdds(savedOdds);
                dto.setMessage("Odds added successfully");
                dto.setStatusCode(200);
            }
        }
        catch(Exception e){
            dto.setStatusCode(500);
            dto.setError(e.getMessage());

        }
        return dto;
    }

    public OddsDTO getAllOdds() {
        OddsDTO dto = new OddsDTO();

        try{
            List<Odds> oddsResultsList = oddsRepo.findAll();
            if(!oddsResultsList.isEmpty()){
                dto.setOodsList(oddsResultsList);
                dto.setStatusCode(200);
                dto.setMessage("Successful");
            }
            else{
                dto.setStatusCode(404);
                dto.setMessage("No oods Found");
            }

        }
        catch(Exception e){
            dto.setStatusCode(500);
            dto.setError("An Error Occured" + e.getMessage());
            

        }
        return dto;
    }

    public OddsDTO updateOdds(Long id, Odds updatedOdds){
        OddsDTO dto = new OddsDTO();
        try{
            Optional<Odds> oodsOptional =  oddsRepo.findById(id);
            if(oodsOptional.isPresent()){   
                Odds odds = oodsOptional.get();         
            odds.setHomeTeam(updatedOdds.getHomeTeam());
            odds.setAwayTeam(updatedOdds.getAwayTeam());
            odds.setOods(updatedOdds.getOods());
            odds.setTime(updatedOdds.getTime());
            odds.setDescription(updatedOdds.getDescription());

            Odds saveOdds = oddsRepo.save(odds);
            dto.setOdds(saveOdds);
            dto.setStatusCode(200);
            dto.setMessage("updated successfully");
            }
            else{
                dto.setStatusCode(404);
                dto.setMessage("not found for updates");
            }

        }
        catch(Exception e){
            dto.setStatusCode(500);
            dto.setMessage("Error occured while updating" + e.getMessage());

        }
        return dto;
    }

    public OddsDTO deleteOdds(Long id){
        OddsDTO dto = new OddsDTO();
        try{
            Optional<Odds> oddsOptional = oddsRepo.findById(id);
            if(oddsOptional.isPresent()){
                oddsRepo.deleteById(id);
                dto.setStatusCode(200);
                dto.setMessage("deleted successfully");

            }
            else{
                dto.setStatusCode(404);
                dto.setMessage("not found");
            }
            
        }
        catch(Exception e){
            dto.setStatusCode(500);
            dto.setMessage("deletion failed");

        }
        return dto;
    }

}


