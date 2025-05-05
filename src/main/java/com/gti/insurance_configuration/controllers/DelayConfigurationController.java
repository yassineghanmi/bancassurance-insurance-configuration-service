package com.gti.insurance_configuration.controllers;

import com.gti.insurance_configuration.models.requests.DelayConfigurationUpdateRequest;
import com.gti.insurance_configuration.models.responses.DelayConfigurationResponse;
import com.gti.insurance_configuration.models.responses.PathConfigurationResponse;
import com.gti.insurance_configuration.services.impl.DelayConfigurationServiceImp;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/v1/delay-config")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class DelayConfigurationController {
    private final DelayConfigurationServiceImp service;

    @GetMapping("/paginated")
    public Page<DelayConfigurationResponse> getAllPaginated(
            @RequestParam(value = "assurance",required = false) String insurance,
            @RequestParam(value = "offset",defaultValue = "0") Integer page,
            @RequestParam(value = "limit", defaultValue = "5") Integer size) {
        insurance = Optional.ofNullable(insurance)
                .filter(s -> !s.trim().isEmpty())
                .orElse(null);
        return service.findAllWithFilters(insurance,page,size);
    }

    @GetMapping("/{id}")
    public DelayConfigurationResponse get(@PathVariable("id") Long id){
        return service.get(id);
    }

    @PutMapping("/{id}")
    public DelayConfigurationResponse update(@PathVariable("id") Long id, @RequestBody DelayConfigurationUpdateRequest request){
        return service.update(id,request);
    }
}
