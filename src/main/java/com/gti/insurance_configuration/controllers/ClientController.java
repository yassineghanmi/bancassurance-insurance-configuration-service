package com.gti.insurance_configuration.controllers;

import com.gti.insurance_configuration.services.ClientCategoryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class ClientController {

    private final ClientCategoryService clientCategoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<String>> getAllCategories() {
        return ResponseEntity.ok(clientCategoryService.getAllClientCategoryLabels());
    }
}