package com.gti.insurance_configuration.controllers;

import com.gti.insurance_configuration.models.requests.JokerInsuranceConfigCreateRequest;
import com.gti.insurance_configuration.models.requests.JokerInsuranceConfigUpdateRequest;
import com.gti.insurance_configuration.models.responses.JokerInsuranceConfigurationResponse;
import com.gti.insurance_configuration.services.impl.JokerInsuranceConfigurationServiceImp;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/joker-insurance-configuration")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class JokerInsuranceConfigurationController {
    private final JokerInsuranceConfigurationServiceImp service;

    @GetMapping("/paginated")
    public Page<JokerInsuranceConfigurationResponse> getAllPaginated(
            @RequestParam(value = "assureur",required = false) String insurer,
            @RequestParam(value = "assurance",required = false) String insurance,
            @RequestParam(value = "profilClient",required = false) String clientProfile,
            @RequestParam(value = "offset",defaultValue = "0") Integer page,
            @RequestParam(value = "limit", defaultValue = "5") Integer size) {
        insurer = Optional.ofNullable(insurer)
                .filter(s -> !s.trim().isEmpty())
                .orElse(null);

        insurance = Optional.ofNullable(insurance)
                .filter(s -> !s.trim().isEmpty())
                .orElse(null);

        clientProfile = Optional.ofNullable(clientProfile)
                .filter(s -> !s.trim().isEmpty())
                .orElse(null);
        return service.findAllWithFilters(insurer,insurance,clientProfile,page,size);
    }

    @GetMapping("/{id}")
    public JokerInsuranceConfigurationResponse get(@PathVariable("id") Long id){
        return service.get(id);
    }

    @PostMapping
    public JokerInsuranceConfigurationResponse create(@RequestBody JokerInsuranceConfigCreateRequest request){
        return service.create(request);
    }

    @PutMapping("/{id}")
    public JokerInsuranceConfigurationResponse update(@PathVariable("id") Long id,@RequestBody JokerInsuranceConfigUpdateRequest request){
        return service.update(id,request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }
}