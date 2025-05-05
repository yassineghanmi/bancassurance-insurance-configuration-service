package com.gti.insurance_configuration.models.responses;

public record CompositeConfigResponse (long id,
                                       String assurance,
                                       double seuilMontant,
                                       int seuilAge,
                                       boolean maladie,
                                       boolean compteJoint,
                                       boolean rembNonMensuel,
                                       boolean franchise,
                                       DelayConfigurationResponse delayConfiguration,
                                       PathConfigurationResponse pathConfiguration){
}
