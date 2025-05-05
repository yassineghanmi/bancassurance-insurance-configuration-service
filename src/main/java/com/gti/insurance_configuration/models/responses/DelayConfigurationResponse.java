package com.gti.insurance_configuration.models.responses;

public record DelayConfigurationResponse(
        long id,
        int delaiAnnulation ,
        int delaiResiliation,
        Long thresholdsConfigurationId,
        String thresholdsConfigurationAssurance
) {
}
