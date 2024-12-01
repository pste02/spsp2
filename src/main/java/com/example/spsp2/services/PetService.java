package com.example.spsp2.services;

import com.example.spsp2.dao.NameAndBreed;
import com.example.spsp2.entities.Pet;
import com.example.spsp2.services.exceptions.BadDataException;
import com.example.spsp2.services.exceptions.NotFoundException;

import java.util.List;

public interface PetService {
    Pet createPet(Pet pet) throws BadDataException;
    List<Pet> readAllPets();
    Pet readPetById(Long id) throws NotFoundException;
    Pet updatePet(Pet pet) throws BadDataException;
    void deletePetById(Long id);
    void deletePetsByName(String name);
    List<Pet> findPetsByAnimalType(String animalType);
    List<Pet> findPetsByBreed(String breed);
    List<NameAndBreed> getNameAndBreedOnly();
    String getStatistics();
}
