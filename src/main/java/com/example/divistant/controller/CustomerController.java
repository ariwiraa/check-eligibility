package com.example.divistant.controller;

import com.example.divistant.model.dto.CustomerRequest;
import com.example.divistant.model.dto.DataResponse;
import com.example.divistant.model.entity.Customer;
import com.example.divistant.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<DataResponse<Customer>> create(@Valid @RequestBody CustomerRequest request) throws Exception {
        Customer customer = customerService.create(request);

        return DataResponse.created(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponse<Customer>> create(@PathVariable Integer id) throws Exception {
        Customer customer = customerService.getById(id);

        return DataResponse.ok(customer);
    }
}
