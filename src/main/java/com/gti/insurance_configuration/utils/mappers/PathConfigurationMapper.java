package com.gti.insurance_configuration.utils.mappers;

import com.gti.insurance_configuration.models.requests.PathConfigurationUpdateRequest;
import com.gti.insurance_configuration.models.responses.PathConfigurationResponse;
import com.gti.insurance_configuration.repositories.entities.PathConfiguration;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PathConfigurationMapper {

    PathConfigurationResponse toDto(PathConfiguration entity);
    PathConfiguration toEntity(PathConfigurationUpdateRequest updateDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(PathConfigurationUpdateRequest dto, @MappingTarget PathConfiguration entity);
}
