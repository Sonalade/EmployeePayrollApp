package com.example.employeepayroll.service;


import com.example.employeepayroll.dto.EmployeeDto;
import com.example.employeepayroll.model.Employee;
import com.example.employeepayroll.repository.EmpRepo;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//service logic
@Service
public class EmpService {
    private List<Employee> employeeList=new ArrayList<>();

    @Autowired
    EmpRepo empRepo;

    public Employee addEmployeeDto(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto);
        employeeList.add(employee);
       return empRepo.save(employee);
    }

    public Employee getEmployee(int id){
        return empRepo.findById(id).orElse(null);
    }

    public String deleteEmployee(int id) {
        empRepo.deleteById(id);
        return "deleted successfully";
    }

    public Employee updateEmployee(@NotNull EmployeeDto emp, int id){
        Employee empobject = new Employee(emp);
        empobject.setEmployeeId(id);
        return empRepo.save(empobject);
    }

    public List<Employee> getAllEmployeePeople() {
        return empRepo.findAll();
    }


//    public EmployeeDto addEmployeeDto(EmployeeDto employeeDto) {
//        return empRepo.save(employeeDto);
//    }

//    public EmployeeDto getById(int id) {
//        return empRepo.findById(id).orElse(null);
//
//    }
//
//    public String deleteById(int id) {
//        empRepo.deleteById(id);
//        return "deleted successfully";
//    }
//    public EmployeeDto updateById(int id, EmployeeDto employeeDto) {
//        employeeDto.setId(id);
//        return empRepo.save(employeeDto);
//    }

//    public EmployeeModel updateEmpData(EmployeeDto employeeDto,int id) {
//        Employee employeeModel2 = employeeModellist.stream().filter(employeeModel -> employeeModel.getEmployeeId()==id).findFirst().orElseThrow(() -> new EmployeePayrollException("Employee id not present"));
//
//        employeeModel2.setName(employeeDto.name);
//        employeeModel2.setSalary(employeeDto.salary);
//        return employeeModel2;
//    }
//    public List<EmployeeDto> getAllEmployeeDtoPeople() {
//        return empRepo.findAll();
//    }

}
