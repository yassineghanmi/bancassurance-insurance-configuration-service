package com.gti.insurance_configuration.repositories.entities;

import com.gti.insurance_configuration.models.enums.NiveauValidation;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "insurance_type", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"assurance", "assureur", "profilClient"}))
public abstract class InsuranceConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String assurance;
    private String assureur;
    private String profilClient;
    private String contrat;
    private String versement;
    private String codeProduitDelta;
    private boolean renouvelAuto;
    private double tva;
    private double ras;
    private double fraisDossAssureur;
    private double fraisDossUib;
    private int ageSouscriptionMax;
    private int ageEcheance;
    @Enumerated(EnumType.STRING)
    private NiveauValidation niveauValidation;
    private boolean etat;
}