package com.codegym.repository.impl;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomerRepositoryImpl implements ICustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean saveWithStoredProcedure(Customer customer) {

        String sql = "CALL Insert_Customer(:firstName, :lastName)";
        Query query =  entityManager.createNativeQuery(sql);
        query.setParameter("firstName", customer.getFirstname());
        query.setParameter("lastName", customer.getLastname());
        return query.executeUpdate() != 0;
    }
}
