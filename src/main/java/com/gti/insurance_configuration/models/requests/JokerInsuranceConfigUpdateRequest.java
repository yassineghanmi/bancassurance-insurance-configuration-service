package com.gti.insurance_configuration.models.requests;

public record JokerInsuranceConfigUpdateRequest (
        String assurance,
        String assureur,
        String profilClient,
        String contrat,
        String versement,
        String codeProduitDelta,
        Boolean renouvelAuto,
        Double tva,
        Double ras,
        Double fraisDossAssureur,
        Double fraisDossUib,
        Integer ageSouscriptionMax,
        Integer ageEcheance,
        String niveauValidation,
        Boolean etat,
        Double primeAssureur,
        Double margeBanque
){
}
