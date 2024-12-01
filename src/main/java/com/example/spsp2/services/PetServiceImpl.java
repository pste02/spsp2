package com.example.spsp2.services;

import com.example.spsp2.dao.NameAndBreed;
import com.example.spsp2.dao.PetRepository;
import com.example.spsp2.entities.Pet;
import com.example.spsp2.services.exceptions.BadDataException;
import com.example.spsp2.services.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class PetServiceImpl implements PetService{
    private PetRepository petRepository;
    @Override
    public Pet createPet(Pet pet) throws BadDataException {
        if(pet.getHouseHold() == null){
            throw new BadDataException("household is null");
        }
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> readAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet readPetById(Long id) throws NotFoundException {
        return petRepository.findById(id).orElseThrow(()-> new NotFoundException("id"+id+"nichtgefunden"));
    }

    @Override
    public Pet updatePet(Pet pet) throws BadDataException {
        petRepository.deleteById(pet.getId());
        return this.createPet(pet);
    }

    @Override
    public void deletePetById(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public void deletePetsByName(String name) {
    }

    @Override
    public List<Pet> findPetsByAnimalType(String animalType) {
        return petRepository.findPetsByAnimalType(animalType);
    }

    @Override
    public List<Pet> findPetsByBreed(String breed) {
        return null;
    }

    @Override
    public List<NameAndBreed> getNameAndBreedOnly() {
        return petRepository.findAll()
                .stream()
                .map(e -> new NameAndBreed(e.getName(), e.getBreed()))
                .collect(Collectors.toList());
    }

    @Override
    public String getStatistics() {
        return "avg age count"+ petRepository.count();
    }
}
