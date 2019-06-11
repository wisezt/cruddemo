package com.artengu.springboot.cruddemo.springdatajpa;

import com.artengu.springboot.cruddemo.entity.Employee;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Service;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
