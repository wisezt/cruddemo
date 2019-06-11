package com.artengu.springboot.cruddemo.dao;


import com.artengu.springboot.cruddemo.entity.EmployeeEntity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Primary
@Repository
public class EmployeeDAOJpaImp implements EmployeeDAO{


    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImp(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }



    @Override
    //@Transactional
    public List<EmployeeEntity> findAll() {



        TypedQuery<EmployeeEntity> theQuery =
                entityManager.createQuery("from EmployeeEntity", EmployeeEntity.class);

        List<EmployeeEntity> employeeEntities = theQuery.getResultList();


        return employeeEntities;
    }

    @Override
    public EmployeeEntity findById(int theId) {


        EmployeeEntity theEmployee = entityManager.find(EmployeeEntity.class, theId);
        return theEmployee;
    }

    @Override
    public void save(EmployeeEntity theEmployeeEntity) {

        EmployeeEntity dbEmployee = entityManager.merge(theEmployeeEntity);

        theEmployeeEntity.setId(dbEmployee.getId());

        System.out.println("******* the Employee id:" + theEmployeeEntity.getId());

    }


    @Override
    public void deleteById(int theId) {




        Query theQuery = entityManager.createQuery("delete from EmployeeEntity where id=: employeeId");


        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();


    }
}
