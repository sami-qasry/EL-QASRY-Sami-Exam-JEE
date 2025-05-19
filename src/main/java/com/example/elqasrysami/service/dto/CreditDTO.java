package com.example.elqasrysami.service.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
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

    public void setTypeCredit(String personnel) {
    }

    public void setMotif(String motif) {

    }

    public void setTypeBien(String typeBien) {
    }

    public void setRaisonSociale(String raisonSociale) {
    }
}
