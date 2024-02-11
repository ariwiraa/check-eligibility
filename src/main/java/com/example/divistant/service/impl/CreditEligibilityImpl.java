package com.example.divistant.service.impl;

import com.example.divistant.exception.custom.NotFoundException;
import com.example.divistant.model.entity.Customer;
import com.example.divistant.repository.CustomerRepository;
import com.example.divistant.service.CreditEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditEligibilityImpl implements CreditEligibilityService {
    private final static Integer STANDARD_INCOME = 1000000;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public String checkEligibility(Integer customerId) throws Exception {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new NotFoundException("Id doesn't exists"));

        if (customer.getIncome() > STANDARD_INCOME) {
            return "Diterima";
        } else {
            return "Ditolak";
        }

    }
}
