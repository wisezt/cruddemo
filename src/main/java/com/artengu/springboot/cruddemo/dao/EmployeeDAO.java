package com.artengu.springboot.cruddemo.dao;

import com.artengu.springboot.cruddemo.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeDAO {
    public List<EmployeeEntity> findAll();

    public EmployeeEntity findById(int theId);

    public void save(EmployeeEntity theEmployeeEntity);

    public void deleteById(int theId);
}
