package com.gti.insurance_configuration.services;

import com.gti.insurance_configuration.models.requests.CompositeConfigCreateRequest;
import com.gti.insurance_configuration.models.responses.*;

import java.util.List;

public interface CompositeConfigService {

    List<CompositeConfigResponse> getAll();
    CompositeConfigResponse getById(Long id);
    CompositeConfigResponse create(CompositeConfigCreateRequest request);
    void delete(Long id);
}
