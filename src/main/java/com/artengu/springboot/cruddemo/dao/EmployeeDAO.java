package com.artengu.springboot.cruddemo.dao;

import com.artengu.springboot.cruddemo.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeDAO {
    public List<EmployeeEntity> findAll();
}
