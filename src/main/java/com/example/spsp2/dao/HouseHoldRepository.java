package com.example.spsp2.dao;

import com.example.spsp2.entities.HouseHold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HouseHoldRepository extends JpaRepository<HouseHold, String> {
    @Query("SELECT h FROM HouseHold h LEFT JOIN FETCH h.pets p WHERE h.eircode = :eircode")
    Optional<HouseHold> findByEircodeWithPets(@Param("eircode") String eircode);

    @Query("SELECT h from HouseHold h where h.pets IS EMPTY ")
    List<HouseHold> findListOfHouseholdsWithNoPets();
}
