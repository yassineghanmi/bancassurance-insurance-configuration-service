package com.gti.insurance_configuration.services.impl;

import com.gti.insurance_configuration.models.requests.DelayConfigurationUpdateRequest;
import com.gti.insurance_configuration.models.responses.DelayConfigurationResponse;
import com.gti.insurance_configuration.repositories.DelayConfigurationRepository;
import com.gti.insurance_configuration.repositories.entities.DelayConfiguration;
import com.gti.insurance_configuration.services.DelayConfigurationService;
import com.gti.insurance_configuration.utils.mappers.DelayConfigurationMapper;
import com.gti.insurance_configuration.utils.validator.DelayConfigurationValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DelayConfigurationServiceImp implements DelayConfigurationService {
    private final DelayConfigurationRepository repository;
    private final DelayConfigurationMapper mapper;
    private final DelayConfigurationValidator validator;

    @Override
    public Page<DelayConfigurationResponse> findAllWithFilters(String insurance, int page, int size) {
        return repository.findAllWithFilters(insurance,PageRequest.of(page,size)).map(mapper::toDto);
    }

    @Override
    public DelayConfigurationResponse get(Long id){
        validator.validateExists(id);
        DelayConfiguration entity = repository.findById(id).orElse(null);
        return mapper.toDto(entity);
    }

    @Override
    public DelayConfigurationResponse update(Long id, DelayConfigurationUpdateRequest request) {
        validator.validateExists(id);
        DelayConfiguration existing = repository.findById(id).orElse(null);
        mapper.updateEntityFromDto(request,existing);
        return mapper.toDto(repository.save(existing));
    }


}

