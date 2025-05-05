package com.gti.insurance_configuration.services;

import com.gti.insurance_configuration.models.requests.DelayConfigurationUpdateRequest;
import com.gti.insurance_configuration.models.responses.DelayConfigurationResponse;
import org.springframework.data.domain.Page;

public interface DelayConfigurationService {
    Page<DelayConfigurationResponse> findAllWithFilters(String insurance, int page, int size);
    DelayConfigurationResponse get(Long id);
    DelayConfigurationResponse update(Long id, DelayConfigurationUpdateRequest request);
}
