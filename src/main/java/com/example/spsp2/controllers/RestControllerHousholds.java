package com.example.spsp2.controllers;

import com.example.spsp2.entities.HouseHold;
import com.example.spsp2.entities.Pet;
import com.example.spsp2.services.HouseHoldService;
import com.example.spsp2.services.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
@RequestMapping("/myapi/households")
public class RestControllerHousholds {

    private final HouseHoldService houseHoldService;

    @GetMapping({"", "/"})
    List<HouseHold> getAllTheHouseholds(){
        return houseHoldService.findAll();
    }

    @GetMapping({"", "/without_pets"})
    List<HouseHold> getAllTheHouseholdsWithoutPets(){
        return houseHoldService.findListOfHouseholdsWithNoPets();
    }

    @GetMapping({"/{id}"})
    HouseHold getHousehold(@PathVariable("id") String id) throws NotFoundException {
        return houseHoldService.findHouseholdByEircode(id);
    }

    @DeleteMapping({"/{id}"})
    void deleteHousehold(@PathVariable("id") String id){
        houseHoldService.deleteHousholdById(id);
    }

}
