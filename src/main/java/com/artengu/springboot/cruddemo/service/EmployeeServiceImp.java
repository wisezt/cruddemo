package com.artengu.springboot.cruddemo.service;


import com.artengu.springboot.cruddemo.entity.EmployeeEntity;
import com.artengu.springboot.cruddemo.springdatajpa.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements  EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImp( EmployeeRepository theEmployeeRepository){
        employeeRepository =  theEmployeeRepository;
    }


    @Override
    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity findById(int theId) {
        EmployeeEntity theEmployee = null;

        Optional<EmployeeEntity> result =
                employeeRepository.findById(theId);
        if (result.isPresent()){
            theEmployee = result.get();
        }
        else{
            throw new RuntimeException("Did not find employee id - " +
                    theId);
        }

        return theEmployee;
    }

    @Override
    public void save(EmployeeEntity theEmployeeEntity) {
        employeeRepository.save(theEmployeeEntity);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
