package com.gti.insurance_configuration.models.responses;

public record ThresholdsConfigurationResponse(long id,
                                              String assurance,
                                              double seuilMontant,
                                              int seuilAge,
                                              boolean maladie,
                                              boolean compteJoint,
                                              boolean rembNonMensuel,
                                              boolean franchise){
}
