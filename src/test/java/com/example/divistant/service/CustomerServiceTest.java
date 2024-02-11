package com.example.divistant.service;

import com.example.divistant.exception.custom.BadRequestException;
import com.example.divistant.exception.custom.NotFoundException;
import com.example.divistant.model.dto.CustomerRequest;
import com.example.divistant.model.entity.Customer;
import com.example.divistant.repository.CustomerRepository;
import com.example.divistant.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerServiceImpl customerService;

    @BeforeEach
    public void setMockTest() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setNik("1234567812345678");
        customer.setName("name");
        customer.setIncome(2000000);

        lenient().when(customerRepository.save(any())).thenReturn(customer);
        lenient().when(customerRepository.findById(anyInt())).thenReturn(Optional.of(customer));
    }

    @Test
    public void TestCreateCustomer_ThenSuccess() throws Exception {
        CustomerRequest request = new CustomerRequest("1234567812345678", "name", 2000000);

        Customer customer = customerService.create(request);

        assertEquals(request.getName(), customer.getName());
        assertEquals(request.getNik(), customer.getNik());
        assertEquals(request.getIncome(), customer.getIncome());

        verify(customerRepository, times(1)).save(any());
    }

    @Test
    public void TestFindById_ThenSuccess() throws Exception {
        Customer customer = customerService.getById(1);

        assertEquals(1, customer.getId());


        verify(customerRepository, times(1)).findById(anyInt());
    }


}
