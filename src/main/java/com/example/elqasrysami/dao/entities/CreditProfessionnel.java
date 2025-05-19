package com.example.elqasrysami.dao.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditProfessionnel extends Credit {
    private String motif;
    private String raisonSociale;
}
