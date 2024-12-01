package com.example.spsp2.dao;

import com.example.spsp2.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findPetsByAnimalType(String animalType);

}
