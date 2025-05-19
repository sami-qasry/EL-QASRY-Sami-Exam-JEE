package com.example.elqasrysami;



import com.example.elqasrysami.dao.entities.*;
import com.example.elqasrysami.dao.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final CreditRepository creditRepository;
    private final CreditPersonnelRepository creditPersonnelRepository;
    private final CreditImmobilierRepository creditImmobilierRepository;
    private final CreditProfessionnelRepository creditProfessionnelRepository;
    private final RemboursementRepository remboursementRepository;

    public DataInitializer(
            ClientRepository clientRepository,
            CreditRepository creditRepository,
            CreditPersonnelRepository creditPersonnelRepository,
            CreditImmobilierRepository creditImmobilierRepository,
            CreditProfessionnelRepository creditProfessionnelRepository,
            RemboursementRepository remboursementRepository
    ) {
        this.clientRepository = clientRepository;
        this.creditRepository = creditRepository;
        this.creditPersonnelRepository = creditPersonnelRepository;
        this.creditImmobilierRepository = creditImmobilierRepository;
        this.creditProfessionnelRepository = creditProfessionnelRepository;
        this.remboursementRepository = remboursementRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        // Créer un client
        Client client = new Client();
        client.setNom("Sami EL-QASRY");
        client.setEmail("sami@example.com");
        clientRepository.save(client);

        // Créer un crédit personnel
        CreditPersonnel creditPersonnel = new CreditPersonnel();
        creditPersonnel.setDateDemande(LocalDate.now());
        creditPersonnel.setStatut("EN_COURS");
        creditPersonnel.setMontant(50000.0);
        creditPersonnel.setDureeRemboursement(24);
        creditPersonnel.setTauxInteret(3.5);
        creditPersonnel.setMotif("Achat voiture");
        creditPersonnel.setClient(client);
        creditPersonnelRepository.save(creditPersonnel);

        // Créer un crédit immobilier
        CreditImmobilier creditImmobilier = new CreditImmobilier();
        creditImmobilier.setDateDemande(LocalDate.now().minusDays(10));
        creditImmobilier.setStatut("ACCEPTE");
        creditImmobilier.setDateAcception(LocalDate.now());
        creditImmobilier.setMontant(250000.0);
        creditImmobilier.setDureeRemboursement(120);
        creditImmobilier.setTauxInteret(2.5);
        creditImmobilier.setTypeBien("MAISON");
        creditImmobilier.setClient(client);
        creditImmobilierRepository.save(creditImmobilier);

        // Créer un crédit professionnel
        CreditProfessionnel creditPro = new CreditProfessionnel();
        creditPro.setDateDemande(LocalDate.now().minusDays(20));
        creditPro.setStatut("REJETE");
        creditPro.setMontant(80000.0);
        creditPro.setDureeRemboursement(36);
        creditPro.setTauxInteret(4.2);
        creditPro.setMotif("Investissement");
        creditPro.setRaisonSociale("TechCorp SARL");
        creditPro.setClient(client);
        creditProfessionnelRepository.save(creditPro);

        // Créer des remboursements
        Remboursement r1 = new Remboursement();
        r1.setDate(LocalDate.now());
        r1.setMontant(1500.0);
        r1.setType("MENSUALITE");
        r1.setCredit(creditPersonnel);
        remboursementRepository.save(r1);

        Remboursement r2 = new Remboursement();
        r2.setDate(LocalDate.now().minusMonths(1));
        r2.setMontant(3000.0);
        r2.setType("REMBOURSEMENT_ANTICIPE");
        r2.setCredit(creditImmobilier);
        remboursementRepository.save(r2);

        System.out.println("✅ Données initiales insérées avec succès !");
    }
}
