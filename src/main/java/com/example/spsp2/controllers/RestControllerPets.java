package com.example.spsp2.controllers;

import com.example.spsp2.entities.HouseHold;
import com.example.spsp2.entities.Pet;
import com.example.spsp2.services.HouseHoldService;
import com.example.spsp2.services.PetService;
import com.example.spsp2.services.exceptions.BadDataException;
import com.example.spsp2.services.exceptions.NotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping({"", "/"})
    Pet createPet(@RequestBody @Valid Pet pet) throws BadDataException {
        return petService.createPet(pet);
    }

    @GetMapping("/statistics")
    String getStatistics() {
        return petService.getStatistics();
    }

}

