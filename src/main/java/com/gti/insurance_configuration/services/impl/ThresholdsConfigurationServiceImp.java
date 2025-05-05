package com.gti.insurance_configuration.services.impl;

import com.gti.insurance_configuration.models.requests.ThresholdsConfigUpdateRequest;
import com.gti.insurance_configuration.models.responses.ThresholdsConfigurationResponse;
import com.gti.insurance_configuration.repositories.CompositeConfigRepository;
import com.gti.insurance_configuration.repositories.entities.ThresholdsConfiguration;
import com.gti.insurance_configuration.services.ThresholdsConfigurationService;
import com.gti.insurance_configuration.utils.mappers.ThresholdsConfigurationMapper;
import com.gti.insurance_configuration.utils.validator.ThresholdsConfigurationValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ThresholdsConfigurationServiceImp implements ThresholdsConfigurationService {
    private final CompositeConfigRepository repository;
    private final ThresholdsConfigurationMapper mapper;
    private final ThresholdsConfigurationValidator validator;

    @Override
    public Page<ThresholdsConfigurationResponse> findAllWithFilters(String insurance, int page, int size) {
        return repository.findAllWithFilters(insurance, PageRequest.of(page, size)).map(mapper::toDto);
    }

    @Override
    public ThresholdsConfigurationResponse get(Long id){
        validator.validateExists(id);
        ThresholdsConfiguration entity = repository.findById(id).orElse(null);
        return mapper.toDto(entity);
    }

    @Override
    public ThresholdsConfigurationResponse update(Long id, ThresholdsConfigUpdateRequest request) {
        validator.validateExists(id);
        ThresholdsConfiguration existing = repository.findById(id).orElse(null);
        mapper.updateEntityFromDto(request,existing);
        assert existing != null;
        return mapper.toDto(repository.save(existing));
    }
}
