package com.artengu.springboot.cruddemo.service;

import com.artengu.springboot.cruddemo.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeEntity> findAll();

    public EmployeeEntity findById(int theId);

    public void save(EmployeeEntity theEmployeeEntity);

    public void deleteById(int theId);
}
