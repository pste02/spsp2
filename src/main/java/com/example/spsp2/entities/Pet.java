package com.example.spsp2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "pets")
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String animalType;
    @NotNull
    private String breed;
    @Min(0)
    @NotNull
    private int age;
    @ManyToOne(optional = false)
    @JoinColumn(name="household_fk", nullable = false)
    @JsonBackReference
    @NotNull
    private HouseHold houseHold;


}
