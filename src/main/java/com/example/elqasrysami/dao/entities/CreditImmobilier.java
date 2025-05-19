package com.example.elqasrysami.dao.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("IMMOBILIER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditImmobilier extends Credit {
    private String typeBien; // Appartement, Maison, etc.
}

