package com.ecommerce.odds.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.odds.dtos.OddsDTO;
import com.ecommerce.odds.models.Odds;
import com.ecommerce.odds.service.OddsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class OddsContoller {

    @Autowired
    private final OddsService oddsService;


    @PostMapping("/admin/add-new-odds")
    public ResponseEntity<OddsDTO> addNewOdds(@RequestBody OddsDTO oddsDTO){
        return ResponseEntity.ok(oddsService.addNewOdds(oddsDTO));

    }

    @GetMapping("/adminuser/get-odds")
    public ResponseEntity<OddsDTO> getAllOdds(){
        return ResponseEntity.ok(oddsService.getAllOdds());
    }

    @PutMapping("/admin/update-odds/{id}")
    public ResponseEntity<OddsDTO> updateOdds(@PathVariable Long id, @RequestBody Odds odds){
        return ResponseEntity.ok(oddsService.updateOdds(id, odds));

    }

    @DeleteMapping("/admin/delete-odds/{id}")
    public ResponseEntity<OddsDTO> deleteOdds(@PathVariable Long id){
        return ResponseEntity.ok(oddsService.deleteOdds(id));
    }

}
