package com.gti.insurance_configuration.utils.mappers;

import com.gti.insurance_configuration.models.requests.DelayConfigurationUpdateRequest;
import com.gti.insurance_configuration.models.responses.DelayConfigurationResponse;
import com.gti.insurance_configuration.repositories.entities.DelayConfiguration;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DelayConfigurationMapper {
    DelayConfigurationResponse toDto(DelayConfiguration entity);
    List<DelayConfigurationResponse> toDtoList(List<DelayConfiguration> entities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(DelayConfigurationUpdateRequest dto, @MappingTarget DelayConfiguration entity);
}
