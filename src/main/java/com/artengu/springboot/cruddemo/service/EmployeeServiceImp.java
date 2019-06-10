package com.artengu.springboot.cruddemo.service;

import com.artengu.springboot.cruddemo.dao.EmployeeDAO;
import com.artengu.springboot.cruddemo.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class EmployeeServiceImp implements  EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImp(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }


    @Override
@Transactional
    public List<EmployeeEntity> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public EmployeeEntity findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(EmployeeEntity theEmployeeEntity) {
        employeeDAO.save(theEmployeeEntity);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
