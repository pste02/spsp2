package com.example.spsp2.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "household")
@AllArgsConstructor
@NoArgsConstructor
public class HouseHold {
    @Id
    private String eircode;
    @NotNull
    private int numberOfOccupants;
    @NotNull
    private int max_numberOfOccupants;
    @NotNull
    private Boolean ownerOccupied;
    @OneToMany(mappedBy = "houseHold", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonManagedReference
    private List<Pet> pets;
}
