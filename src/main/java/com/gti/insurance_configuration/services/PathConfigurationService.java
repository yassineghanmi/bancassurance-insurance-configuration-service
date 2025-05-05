package com.gti.insurance_configuration.services;

import com.gti.insurance_configuration.models.requests.PathConfigurationUpdateRequest;
import com.gti.insurance_configuration.models.responses.PathConfigurationResponse;
import org.springframework.data.domain.Page;

public interface PathConfigurationService {

    Page<PathConfigurationResponse> findAllWithFilters(String insurance, int page, int size);
    PathConfigurationResponse get(Long id);
    PathConfigurationResponse update(Long id, PathConfigurationUpdateRequest request);
}
