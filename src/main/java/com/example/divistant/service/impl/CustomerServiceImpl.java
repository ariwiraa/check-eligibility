package com.example.divistant.service.impl;

import com.example.divistant.exception.custom.NotFoundException;
import com.example.divistant.model.dto.CustomerRequest;
import com.example.divistant.model.entity.Customer;
import com.example.divistant.repository.CustomerRepository;
import com.example.divistant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer create(CustomerRequest request) throws Exception {
        Customer customer = new Customer();

        customer.setName(request.getName());
        customer.setNik(request.getNik());
        customer.setIncome(request.getIncome());

        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(Integer customerId) throws Exception {
        return customerRepository.findById(customerId).orElseThrow(() -> new NotFoundException("id doesn't exists"));
    }
}
