package com.gti.insurance_configuration.controllers;

import com.gti.insurance_configuration.models.requests.CompositeConfigCreateRequest;
import com.gti.insurance_configuration.models.responses.CompositeConfigResponse;
import com.gti.insurance_configuration.services.impl.CompositeConfigServiceImp;
import com.gti.insurance_configuration.utils.validator.CompositeConfigValidator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/composite-configuration")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class CompositeConfigController {
    private final CompositeConfigServiceImp service;
private final CompositeConfigValidator validator;
    @GetMapping
    public List<CompositeConfigResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CompositeConfigResponse get(@PathVariable("id") long id){
        return service.getById(id);
    }

    @PostMapping
    public CompositeConfigResponse create(@RequestBody CompositeConfigCreateRequest ins){
        return service.create(ins);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        service.delete(id);
    }

    @PostMapping("/test/{assurance}")
    public ResponseEntity<?> test(@PathVariable("assurance") String assurance){
        validator.validateInsuranceNotExist(assurance);
        return ResponseEntity.ok(assurance);
    }
}
