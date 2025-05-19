package com.example.elqasrysami.dao.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditPersonnel extends Credit {
    private String motif;
}
