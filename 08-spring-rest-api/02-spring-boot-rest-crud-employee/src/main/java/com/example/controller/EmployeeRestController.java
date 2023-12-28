package com.example.controller;

import com.example.dao.EmployeeDAO;
import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
        return this.employeeService.save(employee);
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable("employeeId") int id) {
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        return employeeService.findById(id);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteById(@PathVariable("employeeId") int id) {
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        this.employeeService.deleteById(id);

        return "Deleted employee id - " + id;
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateById(@PathVariable("employeeId") int id, @RequestBody Employee employee) {
        return this.employeeService.updateById(employee);
    }
}
