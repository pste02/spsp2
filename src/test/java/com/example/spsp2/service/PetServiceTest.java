package com.example.spsp2.service;


import com.example.spsp2.dao.PetRepository;
import com.example.spsp2.entities.HouseHold;
import com.example.spsp2.entities.Pet;
import com.example.spsp2.services.HouseHoldService;
import com.example.spsp2.services.PetServiceImpl;
import com.example.spsp2.services.exceptions.BadDataException;
import com.example.spsp2.services.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PetServiceTest {

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetServiceImpl petService;

    private Pet pet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pet = new Pet();
        pet.setId(1L);
        pet.setName("Buddy");
        pet.setAnimalType("Dog");
        pet.setBreed("Labrador");
        pet.setAge(3);
        pet.setHouseHold(new HouseHold("D02XY45", 2, 3, Boolean.TRUE));
    }

    @Test
    public void testReadAllPets() {
        List<Pet> pets = List.of(pet);
        when(petRepository.findAll()).thenReturn(pets);

        List<Pet> foundPets = petService.readAllPets();

        assertNotNull(foundPets);
        assertTrue(foundPets.size() > 0);
        verify(petRepository, times(1)).findAll();
    }

    @Test
    public void testCreatePet() throws BadDataException {
        when(petRepository.save(any(Pet.class))).thenReturn(pet);

        Pet createdPet = petService.createPet(pet);

        assertNotNull(createdPet);
        assertEquals("Buddy", createdPet.getName());
        verify(petRepository, times(1)).save(pet);
    }

}