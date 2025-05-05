package com.gti.insurance_configuration.controllers;

import com.gti.insurance_configuration.models.requests.ThresholdsConfigUpdateRequest;
import com.gti.insurance_configuration.models.responses.ThresholdsConfigurationResponse;
import com.gti.insurance_configuration.services.impl.ThresholdsConfigurationServiceImp;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/threshold-config")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class ThresholdConfigurationController {
    private final ThresholdsConfigurationServiceImp service;

    @GetMapping("/paginated")
    public Page<ThresholdsConfigurationResponse> getAllPaginated(
            @RequestParam(value = "assurance",required = false) String insurance,
            @RequestParam(value = "offset",defaultValue = "0") Integer page,
            @RequestParam(value = "limit", defaultValue = "5") Integer size) {
        insurance = Optional.ofNullable(insurance)
                .filter(s -> !s.trim().isEmpty())
                .orElse(null);
        return service.findAllWithFilters(insurance,page,size);
    }

    @GetMapping("/{id}")
    public ThresholdsConfigurationResponse get(@PathVariable("id") Long id){
        return service.get(id);
    }

    @PutMapping("/{id}")
    public ThresholdsConfigurationResponse update(@PathVariable("id") Long id, @RequestBody ThresholdsConfigUpdateRequest request){
        return service.update(id,request);
    }
}
