package com.example.spsp2.controllers;

import com.example.spsp2.entities.HouseHold;
import com.example.spsp2.entities.Pet;
import com.example.spsp2.services.HouseHoldService;
import com.example.spsp2.services.PetService;
import com.example.spsp2.services.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
@RequestMapping("/myapi/pets")
public class RestControllerPets {
    private final PetService petService;

    @GetMapping({"", "/"})
    List<Pet> getAllPets(){
        return petService.readAllPets();
    }

    @GetMapping({"/{id}"})
    Pet getPet(@PathVariable("id") long id) throws NotFoundException {
        return petService.readPetById(id);
    }

    @DeleteMapping({"/{id}"})
    void deletePet(@PathVariable("id") long id){
        petService.deletePetById(id);
    }
}

