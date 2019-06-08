package com.artengu.springboot.cruddemo.rest;

import com.artengu.springboot.cruddemo.dao.EmployeeDAO;
import com.artengu.springboot.cruddemo.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;


    @Autowired
    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
        System.out.println(employeeDAO.findAll());
    }


    @GetMapping("/employees")
    public List<EmployeeEntity> findAll(){
        System.out.println("**************" + employeeDAO.findAll());
        return employeeDAO.findAll();
    }
//
//    @GetMapping("/employees")
//    public List<EmployeeEntity> findAll() {
//        return employeeDAO.findAll();
//    }





}
