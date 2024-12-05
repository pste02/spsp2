package com.example.spsp2.service;

import com.example.spsp2.dao.HouseHoldRepository;
import com.example.spsp2.entities.HouseHold;
import com.example.spsp2.services.HouseHoldService;
import com.example.spsp2.services.HouseHoldServiceImpl;
import com.example.spsp2.services.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HouseHoldServiceTest {

    @Mock
    private HouseHoldRepository houseHoldRepository;

    @InjectMocks
    private HouseHoldServiceImpl houseHoldService;

    private HouseHold houseHold;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        houseHold = new HouseHold("D02XY45", 2, 3, Boolean.TRUE);
    }

    @Test
    public void testFindHouseholdByEircode() throws NotFoundException {
        when(houseHoldRepository.findById("D02XY45")).thenReturn(Optional.of(houseHold));

        HouseHold foundHouseHold = houseHoldService.findHouseholdByEircode("D02XY45");

        assertNotNull(foundHouseHold);
        assertEquals("D02XY45", foundHouseHold.getEircode());
        verify(houseHoldRepository, times(1)).findById("D02XY45");
    }

    @Test
    public void testFindListOfHouseholdsWithNoPets() {
        List<HouseHold> households = List.of(houseHold);
        when(houseHoldRepository.findListOfHouseholdsWithNoPets()).thenReturn(households);

        List<HouseHold> foundHouseholds = houseHoldService.findListOfHouseholdsWithNoPets();

        assertNotNull(foundHouseholds);
        assertTrue(foundHouseholds.size() > 0);
        verify(houseHoldRepository, times(1)).findListOfHouseholdsWithNoPets();
    }

    @Test
    public void testCreateHousehold() {
        when(houseHoldRepository.save(any(HouseHold.class))).thenReturn(houseHold);

        HouseHold createdHouseHold = houseHoldService.createHousehold(houseHold);

        assertNotNull(createdHouseHold);
        assertEquals("D02XY45", createdHouseHold.getEircode());
        verify(houseHoldRepository, times(1)).save(houseHold);
    }
}