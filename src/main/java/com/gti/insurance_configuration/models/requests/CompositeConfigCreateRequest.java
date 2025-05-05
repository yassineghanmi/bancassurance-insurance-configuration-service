package com.gti.insurance_configuration.models.requests;

public record CompositeConfigCreateRequest(String assurance,
                                           double seuilMontant,
                                           int seuilAge,
                                           boolean maladie,
                                           boolean compteJoint,
                                           boolean rembNonMensuel,
                                           boolean franchise,
                                           DelayConfigurationCreateRequest delayConfiguration,
                                           PathConfigurationCreateRequest pathConfiguration) {
}
