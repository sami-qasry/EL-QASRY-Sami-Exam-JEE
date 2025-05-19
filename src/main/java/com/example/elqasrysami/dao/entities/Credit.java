package com.example.elqasrysami.dao.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // ou JOINED ou TABLE_PER_CLASS selon ton besoin
@DiscriminatorColumn(name = "credit_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateDemande;

    private String statut;

    private LocalDate dateAcception;

    private double montant;

    private int dureeRemboursement;

    private double tauxInteret;

    @ManyToOne
    private Client client;


}
