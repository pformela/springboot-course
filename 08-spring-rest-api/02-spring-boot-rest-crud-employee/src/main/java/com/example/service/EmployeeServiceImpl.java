package com.example.service;

import com.example.dao.EmployeeDAO;
import com.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return this.employeeDAO.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return this.employeeDAO.save(employee);
    }

    @Override
    public void deleteById(int id) {
        this.employeeDAO.deleteById(id);
    }

    @Override
    public Employee updateById(Employee employee) {
        return this.employeeDAO.updateById(employee);
    }
}
