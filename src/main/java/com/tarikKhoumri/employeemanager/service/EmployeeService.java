package com.tarikKhoumri.employeemanager.service;

import com.tarikKhoumri.employeemanager.exception.UserNotFoundException;
import com.tarikKhoumri.employeemanager.model.Employee;
import com.tarikKhoumri.employeemanager.repo.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public  EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmpolyee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    @Transactional
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() ->new UserNotFoundException("User by id" + id + " was not found"));
    }

}
