package com.artengu.springboot.cruddemo.dao;


import com.artengu.springboot.cruddemo.entity.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOImp implements EmployeeDAO{


    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImp(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }



    @Override
    @Transactional
    public List<EmployeeEntity> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<EmployeeEntity> theQuery =
                currentSession.createQuery("from Employee", EmployeeEntity.class);

        List<EmployeeEntity> employeeEntities = theQuery.getResultList();


        return employeeEntities;
    }
}
