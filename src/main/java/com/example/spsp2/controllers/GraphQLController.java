package com.example.spsp2.controllers;

import com.example.spsp2.entities.HouseHold;
import com.example.spsp2.entities.Pet;
import com.example.spsp2.services.HouseHoldService;
import com.example.spsp2.services.PetService;
import com.example.spsp2.services.exceptions.NotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class GraphQLController {

    private final HouseHoldService householdService;
    private final PetService petService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @QueryMapping
    public List<HouseHold> allHouseholds() {
        return householdService.findAll();
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @QueryMapping
    public List<Pet> allPetsByAnimalType(@Argument("animalType") String animalType) {
        return petService.findPetsByAnimalType(animalType);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @QueryMapping
    public HouseHold householdByEircode(@Argument String eircode) throws NotFoundException {
        return householdService.findHouseholdByEircode(eircode);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @QueryMapping
    public Pet petById(@Argument Long id) throws NotFoundException {
        return petService.readPetById(id);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @QueryMapping
    public String getStatistics() {
        return petService.getStatistics();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @MutationMapping
    public HouseHold createHousehold(@Argument @Valid HouseHold input) {
        return householdService.createHousehold(new HouseHold(input.getEircode(), input.getNumberOfOccupants(), input.getMax_numberOfOccupants(), input.getOwnerOccupied()));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @MutationMapping
    public Boolean deleteHouseholdByEircode(@Argument String eircode) {
        householdService.deleteHousholdById(eircode);
        return true;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @MutationMapping
    public Boolean deletePetById(@Argument Long id) {
        petService.deletePetById(id);
        return true;
    }
}