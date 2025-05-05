package com.gti.insurance_configuration.models.requests;

import com.gti.insurance_configuration.models.enums.FrequenceGenerationType;

public record PathConfigurationCreateRequest(
        String cheminGeneration,
        String cheminArchivage,
        String cheminStreamServe,
        String nomFichierStreamServe,
        String frequenceGenerationType
) {
}
