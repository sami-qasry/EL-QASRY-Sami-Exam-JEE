package com.example.elqasrysami.service.dto;

import java.time.LocalDate;
import java.util.List;

public class CreditDTO {
    private Long id;
    private LocalDate dateDemande;
    private String statut;
    private LocalDate dateAcception;
    private double montant;
    private int dureeRemboursement;
    private double tauxInteret;
    private Long clientId;
    private List<RemboursementDTO> remboursements;
}
