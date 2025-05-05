package com.gti.insurance_configuration.utils.mappers;

import com.gti.insurance_configuration.models.requests.DelayConfigurationUpdateRequest;
import com.gti.insurance_configuration.models.requests.JokerInsuranceConfigCreateRequest;
import com.gti.insurance_configuration.models.requests.JokerInsuranceConfigUpdateRequest;
import com.gti.insurance_configuration.models.responses.DelayConfigurationResponse;
import com.gti.insurance_configuration.models.responses.JokerInsuranceConfigurationResponse;
import com.gti.insurance_configuration.repositories.entities.DelayConfiguration;
import com.gti.insurance_configuration.repositories.entities.JokerInsuranceConfiguration;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JokerInsuranceConfigurationMapper {

    JokerInsuranceConfigurationResponse toDto(JokerInsuranceConfiguration entity);
    JokerInsuranceConfiguration toCreateEntity(JokerInsuranceConfigCreateRequest dto);
    JokerInsuranceConfiguration toUpdateEntity(JokerInsuranceConfigUpdateRequest dto);
    List<JokerInsuranceConfigurationResponse> toDtoList(List<JokerInsuranceConfiguration> entities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(JokerInsuranceConfigUpdateRequest dto, @MappingTarget JokerInsuranceConfiguration entity);

}
