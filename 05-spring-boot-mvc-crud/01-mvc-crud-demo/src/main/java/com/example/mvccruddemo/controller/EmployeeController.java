package com.example.mvccruddemo.controller;

import com.example.mvccruddemo.entity.Employee;
import com.example.mvccruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employeeList = this.employeeService.findAll();

        model.addAttribute("employees", employeeList);

        return "list-employees";
    }

    @GetMapping("/new")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        this.employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
        Employee employee = this.employeeService.findById(id);

        model.addAttribute("employee", employee);

        return "employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id) {
        this.employeeService.deleteById(id);

        return "redirect:/employees/list";
    }
}
