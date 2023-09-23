package com.example.employeepayroll.repository;

import com.example.employeepayroll.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Employee,Integer> {

}



//connected by database