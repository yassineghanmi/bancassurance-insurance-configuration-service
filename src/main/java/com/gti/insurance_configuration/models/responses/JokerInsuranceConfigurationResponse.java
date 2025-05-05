package com.gti.insurance_configuration.models.responses;

public record JokerInsuranceConfigurationResponse (    Long id,
                                                       String assurance,
                                                       String assureur,
                                                       String profilClient,
                                                       String contrat,
                                                       String versement,
                                                       String codeProduitDelta,
                                                       boolean renouvelAuto,
                                                       double tva,
                                                       double ras,
                                                       double fraisDossAssureur,
                                                       double fraisDossUib,
                                                       int ageSouscriptionMax,
                                                       int ageEcheance,
                                                       String niveauValidation,
                                                       boolean etat,
                                                       double primeAssureur,
                                                       double margeBanque){

}
