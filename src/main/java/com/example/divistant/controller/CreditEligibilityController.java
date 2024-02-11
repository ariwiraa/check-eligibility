package com.example.divistant.controller;


import com.example.divistant.model.dto.DataResponse;
import com.example.divistant.service.CreditEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditEligibilityController {

    @Autowired
    private CreditEligibilityService creditEligibilityService;

    @GetMapping("/api/check-eligibility/{id}")
    public ResponseEntity<DataResponse<String>> checkEligibility(@PathVariable Integer id) throws Exception {
        String result = creditEligibilityService.checkEligibility(id);

        return DataResponse.ok(result);
    }
}
