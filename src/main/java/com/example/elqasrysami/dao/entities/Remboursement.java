package com.example.elqasrysami.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Remboursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private double montant;
    private String type;

    @ManyToOne
    @JoinColumn(name = "credit_id")
    private Credit credit;
}
