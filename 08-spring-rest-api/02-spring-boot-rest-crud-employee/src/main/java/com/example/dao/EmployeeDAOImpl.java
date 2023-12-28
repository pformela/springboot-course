package com.example.dao;

import com.example.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        return query.getResultList();
    }

    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Transactional
    public Employee save(Employee employee) {
        Employee dBemployee = this.entityManager.merge(employee);

        return dBemployee;
    }

    @Transactional
    public void deleteById(int id) {
        Employee employee = this.findById(id);

        this.entityManager.remove(employee);
    }

    @Transactional
    public Employee updateById(Employee employee) {
        Employee dBemployee = this.entityManager.merge(employee);

        return dBemployee;
    }
}
