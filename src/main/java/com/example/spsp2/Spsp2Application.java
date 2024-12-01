package com.example.spsp2;

import com.example.spsp2.entities.HouseHold;
import com.example.spsp2.services.HouseHoldService;
import com.example.spsp2.services.HouseHoldServiceImpl;
import com.example.spsp2.services.exceptions.NotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

@SpringBootApplication
public class Spsp2Application {

	public static void main(String[] args) throws NotFoundException {
		ApplicationContext applicationContext = SpringApplication.run(Spsp2Application.class, args);
		HouseHoldService houseHoldService = applicationContext.getBean(HouseHoldService.class);
		System.out.println(houseHoldService.findHouseholdByEircode("D02XY45"));
		System.out.println(houseHoldService.findHouseholdByEircodeWithPets("D02XY45").getPets());
		System.out.println(houseHoldService.findListOfHouseholdsWithNoPets());

	}
}
