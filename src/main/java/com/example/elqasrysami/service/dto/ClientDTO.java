package com.example.elqasrysami.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {
    private Long id;
    private String nom;
    private String email;
    private List<CreditDTO> credits; // optionnel, pour éviter des boucles infinies

    }




