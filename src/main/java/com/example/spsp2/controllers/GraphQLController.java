package com.example.spsp2.controllers;

import com.example.spsp2.entities.HouseHold;
import com.example.spsp2.entities.Pet;
import com.example.spsp2.services.HouseHoldService;
import com.example.spsp2.services.PetService;
import com.example.spsp2.services.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class GraphQLController {

    private final HouseHoldService householdService;
    private final PetService petService;

    @QueryMapping
    public List<HouseHold> allHouseholds() {
        return householdService.findAll();
    }

    @QueryMapping
    public List<Pet> allPetsByAnimalType(@Argument("animalType") String animalType) {
        return petService.findPetsByAnimalType(animalType);
    }

    @QueryMapping
    public HouseHold householdByEircode(@Argument String eircode) throws NotFoundException {
        return householdService.findHouseholdByEircode(eircode);
    }

    @QueryMapping
    public Pet petById(@Argument Long id) throws NotFoundException {
        return petService.readPetById(id);
    }

    @QueryMapping
    public String getStatistics() {
        return petService.getStatistics();
    }

    @MutationMapping
    public HouseHold createHousehold(@Argument HouseHold input) {
        return householdService.createHousehold(new HouseHold(input.getEircode(), input.getNumberOfOccupants(), input.getMax_numberOfOccupants(), input.getOwnerOccupied(), new ArrayList<>()));
    }

    @MutationMapping
    public Boolean deleteHouseholdByEircode(@Argument String eircode) {
        householdService.deleteHousholdById(eircode);
        return true;
    }

    @MutationMapping
    public Boolean deletePetById(@Argument Long id) {
        petService.deletePetById(id);
        return true;
    }
}