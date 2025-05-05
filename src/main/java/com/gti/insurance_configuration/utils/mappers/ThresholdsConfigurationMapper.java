package com.gti.insurance_configuration.utils.mappers;

import com.gti.insurance_configuration.models.requests.ThresholdsConfigUpdateRequest;
import com.gti.insurance_configuration.models.responses.ThresholdsConfigurationResponse;
import com.gti.insurance_configuration.repositories.entities.ThresholdsConfiguration;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ThresholdsConfigurationMapper {

    ThresholdsConfigurationResponse toDto(ThresholdsConfiguration thresholdsConfiguration);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(ThresholdsConfigUpdateRequest dto, @MappingTarget ThresholdsConfiguration entity);

}
