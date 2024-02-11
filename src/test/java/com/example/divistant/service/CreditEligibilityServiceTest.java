package com.example.divistant.service;

import com.example.divistant.model.entity.Customer;
import com.example.divistant.repository.CustomerRepository;
import com.example.divistant.service.impl.CreditEligibilityImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CreditEligibilityServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CreditEligibilityImpl creditEligibilityService;

    private List<Customer> customers = new ArrayList<>();

    @BeforeEach
    void setMockTest() {
        this.customers.add(new Customer(1, "1234567812345678", "ari", 2000000));
        this.customers.add(new Customer(2, "2234567812345678", "wira", 500000));
    }

    @Test
    public void TestCheckEligibility_ThenAcc() throws Exception {
        when(customerRepository.findById(anyInt())).thenReturn(Optional.of(customers.get(0)));

        String result = creditEligibilityService.checkEligibility(1);

        assertEquals("Diterima", result);

        verify(customerRepository, times(1)).findById(anyInt());

    }

    @Test
    public void TestCheckEligibility_ThenFailed() throws Exception {
        when(customerRepository.findById(anyInt())).thenReturn(Optional.of(customers.get(1)));

        String result = creditEligibilityService.checkEligibility(2);

        assertEquals("Ditolak", result);

        verify(customerRepository, times(1)).findById(anyInt());

    }
}
