package com.example.employeepayroll.service;

import com.example.employeepayroll.model.Employee;

import java.util.List;

public interface EpService {

    public List<Employee> getAllEmployeePeople();
    public Employee saveData(Employee employee);

}
