package com.gti.insurance_configuration.utils.mappers;

import com.gti.insurance_configuration.models.requests.*;
import com.gti.insurance_configuration.models.responses.CompositeConfigResponse;
import com.gti.insurance_configuration.repositories.entities.ThresholdsConfiguration;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CompositeConfigMapper {
    ThresholdsConfiguration toEntity(CompositeConfigCreateRequest request);
    CompositeConfigResponse toDto(ThresholdsConfiguration entity);
}
