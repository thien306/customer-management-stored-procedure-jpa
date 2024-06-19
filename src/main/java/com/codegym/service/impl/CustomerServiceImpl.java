package com.codegym.service.impl;


import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository ;

    @Override
    public boolean saveWithStoredProcedure(Customer customer) {
        return customerRepository.saveWithStoredProcedure(customer);
    }
}