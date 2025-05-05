package com.gti.insurance_configuration.services.impl;

import com.gti.insurance_configuration.models.requests.JokerInsuranceConfigCreateRequest;
import com.gti.insurance_configuration.models.requests.JokerInsuranceConfigUpdateRequest;
import com.gti.insurance_configuration.models.responses.JokerInsuranceConfigurationResponse;
import com.gti.insurance_configuration.repositories.JokerInsuranceConfigurationRepository;
import com.gti.insurance_configuration.repositories.entities.JokerInsuranceConfiguration;
import com.gti.insurance_configuration.services.JokerInsuranceConfigurationService;
import com.gti.insurance_configuration.utils.mappers.JokerInsuranceConfigurationMapper;
import com.gti.insurance_configuration.utils.validator.JokerInsuranceConfigurationValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JokerInsuranceConfigurationServiceImp implements JokerInsuranceConfigurationService {
    private final JokerInsuranceConfigurationRepository repository;
    private final JokerInsuranceConfigurationMapper mapper;
    private final JokerInsuranceConfigurationValidator validator;
    @Override
    public JokerInsuranceConfigurationResponse get(Long id) {
        validator.validateExists(id);
        return repository.findById(id).map(mapper::toDto).orElse(null);
    }

    @Override
    public Page<JokerInsuranceConfigurationResponse> findAllWithFilters(String insurer, String insurance, String clientProfile, int page, int size) {
        return repository.findAllWithFilters(insurer,insurance, clientProfile, PageRequest.of(page,size)).map(mapper::toDto);
    }

    @Override
    public JokerInsuranceConfigurationResponse create(JokerInsuranceConfigCreateRequest request) {
        validator.validateForCreate(request);
        JokerInsuranceConfiguration entity = mapper.toCreateEntity(request);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public JokerInsuranceConfigurationResponse update(Long id, JokerInsuranceConfigUpdateRequest request) {
        validator.validateForUpdate(id, request);
        JokerInsuranceConfiguration existing = repository.findById(id).orElse(null);
        mapper.updateEntityFromDto(request , existing);
        assert existing != null;
        return mapper.toDto(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        validator.validateExists(id);
        repository.deleteById(id);
    }
}
