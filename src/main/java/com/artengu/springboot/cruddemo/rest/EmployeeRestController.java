package com.artengu.springboot.cruddemo.rest;

import com.artengu.springboot.cruddemo.dao.EmployeeDAO;
import com.artengu.springboot.cruddemo.entity.EmployeeEntity;
import com.artengu.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;


    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
        System.out.println(employeeService.findAll());
    }


    @GetMapping("/employees")
    public List<EmployeeEntity> findAll(){
        System.out.println("**************" + employeeService.findAll());
        return employeeService.findAll();
    }
//
//    @GetMapping("/employees")
//    public List<EmployeeEntity> findAll() {
//        return employeeDAO.findAll();
//    }





}
