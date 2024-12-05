package com.example.spsp2.repository;

import com.example.spsp2.dao.HouseHoldRepository;
import com.example.spsp2.dao.PetRepository;
import com.example.spsp2.entities.Pet;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PetRepositoryTest {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private HouseHoldRepository houseHoldRepository;

    @Test
    public void testFindAll() {
        List<Pet> pets = petRepository.findAll();
        assertNotNull(pets);
        assertTrue(pets.size() > 0);
    }

    @Test
    public void testFindById() {
        Pet pet = petRepository.findById(1L).orElse(null);
        assertNotNull(pet);
    }

    @Test
    public void testSave() {
        Pet pet = new Pet("Max", "Cat", "Siamese", 2, houseHoldRepository.findListOfHouseholdsWithNoPets().getFirst());
        Pet savedPet = petRepository.save(pet);
        assertNotNull(savedPet);
        assertEquals("Max", savedPet.getName());
    }
}