package com.gti.insurance_configuration.services.impl;

import com.gti.insurance_configuration.models.requests.PathConfigurationUpdateRequest;
import com.gti.insurance_configuration.models.responses.PathConfigurationResponse;
import com.gti.insurance_configuration.repositories.PathConfigurationRepository;
import com.gti.insurance_configuration.repositories.entities.PathConfiguration;
import com.gti.insurance_configuration.services.PathConfigurationService;
import com.gti.insurance_configuration.utils.mappers.PathConfigurationMapper;
import com.gti.insurance_configuration.utils.validator.PathConfigurationValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PathConfigurationServiceImp implements PathConfigurationService {
    private final PathConfigurationRepository repository;
    private final PathConfigurationMapper mapper;
    private final PathConfigurationValidator validator;

    @Override
    public Page<PathConfigurationResponse> findAllWithFilters(String insurance,int page, int size) {
        return repository.findAllWithFilters(insurance,PageRequest.of(page, size)).map(mapper::toDto);
    }

    @Override
    public PathConfigurationResponse get(Long id){
        validator.validateExists(id);
        PathConfiguration entity = repository.findById(id).orElse(null);
        return mapper.toDto(entity);
    }

    @Override
    public PathConfigurationResponse update(Long id, PathConfigurationUpdateRequest request) {
        validator.validateForUpdate(request,id);
        PathConfiguration existing = repository.findById(id).orElse(null);
        mapper.updateEntityFromDto(request,existing);
        return mapper.toDto(repository.save(existing));
    }

}
