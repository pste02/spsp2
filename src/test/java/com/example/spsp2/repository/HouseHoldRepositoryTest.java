package com.example.spsp2.repository;


import com.example.spsp2.dao.HouseHoldRepository;
import com.example.spsp2.entities.HouseHold;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HouseHoldRepositoryTest {

    @Autowired
    private HouseHoldRepository houseHoldRepository;

    @Test
    public void testFindAll() {
        List<HouseHold> households = houseHoldRepository.findAll();
        assertNotNull(households);
        assertTrue(households.size() > 0);
    }

    @Test
    public void testCountByNumberOfOccupants() {
        long count = houseHoldRepository.countByNumberOfOccupants(0);
        assertTrue(count >= 0);
    }

    @Test
    public void testSave() {
        HouseHold houseHold = new HouseHold("D02XY47", 2, 3, Boolean.TRUE);
        HouseHold savedHouseHold = houseHoldRepository.save(houseHold);
        assertNotNull(savedHouseHold);
        assertEquals("D02XY47", savedHouseHold.getEircode());
    }
}