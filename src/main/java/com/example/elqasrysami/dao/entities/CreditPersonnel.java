package com.example.elqasrysami.dao.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("PERSONNEL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditPersonnel extends Credit {
    private String motif;
}

