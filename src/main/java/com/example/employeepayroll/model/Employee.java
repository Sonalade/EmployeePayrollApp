package com.example.employeepayroll.model;


import com.example.employeepayroll.dto.EmployeeDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    private String name;
    private String startDate;
    private String gender;
    private String note;
    private String department;
    private String profilePic;
    private long salary;

    public Employee(EmployeeDto employeeDto) {    //Save

        this.name = employeeDto.name;
        this.salary = employeeDto.salary;
        this.gender = employeeDto.gender;
        this.startDate = employeeDto.startDate;
        this.note = employeeDto.note;
        this.profilePic = employeeDto.profilePic;
        this.department = employeeDto.department;

    }

    public Employee(int employeeId,EmployeeDto employeeDto) {    //update

        this.employeeId=employeeId;
        this.name = employeeDto.name;
        this.salary = employeeDto.salary;
        this.gender = employeeDto.gender;
        this.startDate = employeeDto.startDate;
        this.note = employeeDto.note;
        this.profilePic = employeeDto.profilePic;
        this.department = employeeDto.department;

    }



}