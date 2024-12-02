package com.example.spsp2.services;

import com.example.spsp2.dao.HouseHoldRepository;
import com.example.spsp2.entities.HouseHold;
import com.example.spsp2.services.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class HouseHoldServiceImpl implements HouseHoldService {
    private HouseHoldRepository houseHoldRepository;
    @Override
    public HouseHold findHouseholdByEircode(String eircode) throws NotFoundException {
        Optional<HouseHold> h = houseHoldRepository.findById(eircode);
        if(h.isEmpty()){
            throw new NotFoundException("does not exist");
        }else{
            return h.get();
        }
    }

    @Override
    public HouseHold findHouseholdByEircodeWithPets(String eircode) throws NotFoundException {
        Optional<HouseHold> h = houseHoldRepository.findByEircodeWithPets(eircode);
        if(h.isEmpty()){
            throw new NotFoundException("does not exist");
        }
        return h.get();
    }

    @Override
    public List<HouseHold> findListOfHouseholdsWithNoPets() {
        return houseHoldRepository.findListOfHouseholdsWithNoPets();
    }

    @Override
    public void deleteHousholdById(String eircode) {
        houseHoldRepository.deleteById(eircode);
    }

    @Override
    public List<HouseHold> findAll() {
        return houseHoldRepository.findAll();
    }

    @Override
    public HouseHold createHousehold(HouseHold household) {
        return houseHoldRepository.save(household);
    }

    @Override
    public String getStatistics() {
        long totalHouseholds = houseHoldRepository.count();
        long uninhabitedHouseholds = houseHoldRepository.countByNumberOfOccupants(0);
        return String.format("Total Households: %d, Uninhabited Households: %d", totalHouseholds, uninhabitedHouseholds);
    }
}
