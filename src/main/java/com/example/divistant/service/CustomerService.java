package com.example.divistant.service;

import com.example.divistant.model.dto.CustomerRequest;
import com.example.divistant.model.entity.Customer;

public interface CustomerService {
    Customer create(CustomerRequest request) throws Exception ;
    Customer getById(Integer customerId) throws Exception;
}
