package com.gti.insurance_configuration.models.requests;

public record PathConfigurationUpdateRequest (
        String cheminGeneration,
        String cheminArchivage,
        String cheminStreamServe,
        String nomFichierStreamServe,
        String frequenceGenerationType
){
}
