package com.gti.insurance_configuration.models.responses;

import com.gti.insurance_configuration.models.enums.FrequenceGenerationType;

public record PathConfigurationResponse(long id,
                                        String cheminGeneration,
                                        String cheminArchivage,
                                        String cheminStreamServe,
                                        String nomFichierStreamServe,
                                        FrequenceGenerationType frequenceGenerationType,
                                        Long thresholdsConfigurationId,
                                        String thresholdsConfigurationAssurance) {
}
