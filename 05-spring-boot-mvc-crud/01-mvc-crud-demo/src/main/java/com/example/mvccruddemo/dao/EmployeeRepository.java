package com.example.mvccruddemo.dao;

import com.example.mvccruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    List<Employee> findAllByOrderByLastNameAsc();
}
