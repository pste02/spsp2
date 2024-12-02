package com.example.spsp2.services;

import com.example.spsp2.entities.HouseHold;
import com.example.spsp2.entities.Pet;
import com.example.spsp2.services.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface HouseHoldService {

    HouseHold findHouseholdByEircode(String eircode) throws NotFoundException;
    HouseHold findHouseholdByEircodeWithPets(String eircode) throws NotFoundException;
    List<HouseHold> findListOfHouseholdsWithNoPets();

    void deleteHousholdById(String eircode);

    List<HouseHold> findAll();

    HouseHold createHousehold(HouseHold household);

    String getStatistics();
}
