package com.gti.insurance_configuration.repositories.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("JOKER")
@Data
@NoArgsConstructor
public class JokerInsuranceConfiguration extends InsuranceConfiguration {
    private double primeAssureur;
    private double margeBanque;
}