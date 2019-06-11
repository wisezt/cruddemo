package com.artengu.springboot.cruddemo.rest;

import com.artengu.springboot.cruddemo.entity.EmployeeEntity;
import com.artengu.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees/{employeeId}")
    public EmployeeEntity getEmployee(@PathVariable int employeeId){

        EmployeeEntity  theEmployeeEntity = employeeService.findById(employeeId);

        if (theEmployeeEntity ==null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployeeEntity;
    }

    @PostMapping("/employees")
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity theEmployee){

            theEmployee.setId(0);

            employeeService.save(theEmployee);

             return theEmployee;
    }



    @PutMapping("/employees")
    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity theEmployee){

        employeeService.save(theEmployee);

        return theEmployee;


    }


    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        EmployeeEntity theEmployee = employeeService.findById(employeeId);

        if (theEmployee ==null){
            throw new RuntimeException("Employee id not found -" + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted Employee by Id " + employeeId;
    }





}
