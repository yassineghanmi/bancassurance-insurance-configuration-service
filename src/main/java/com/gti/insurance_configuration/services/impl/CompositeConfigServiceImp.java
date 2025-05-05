package com.gti.insurance_configuration.services.impl;

import com.gti.insurance_configuration.models.requests.CompositeConfigCreateRequest;
import com.gti.insurance_configuration.models.responses.CompositeConfigResponse;
import com.gti.insurance_configuration.repositories.CompositeConfigRepository;
import com.gti.insurance_configuration.repositories.entities.*;
import com.gti.insurance_configuration.services.CompositeConfigService;
import com.gti.insurance_configuration.utils.mappers.CompositeConfigMapper;
import com.gti.insurance_configuration.utils.validator.CompositeConfigValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CompositeConfigServiceImp implements CompositeConfigService {
    private final CompositeConfigRepository repository;
    private final CompositeConfigValidator validator;
    private final CompositeConfigMapper mapper;

    @Override
    public List<CompositeConfigResponse> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public CompositeConfigResponse getById(Long id) {
        validator.validateExists(id);
        return repository.findById(id).map(mapper::toDto).orElse(null);
    }

    @Override
    public CompositeConfigResponse create(CompositeConfigCreateRequest request) {
        validator.validateForCreate(request.pathConfiguration(), request.assurance());
        ThresholdsConfiguration entity = mapper.toEntity(request);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        validator.validateExists(id);
        repository.deleteById(id);
    }
}
