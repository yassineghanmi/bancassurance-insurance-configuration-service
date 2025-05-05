package com.gti.insurance_configuration.models.requests;

public record DelayConfigurationUpdateRequest (
        Integer delaiAnnulation ,
        Integer delaiResiliation
){
}
