package com.example.employeepayroll.controller;

import com.example.employeepayroll.dto.EmployeeDto;
import com.example.employeepayroll.dto.ResponseDto;
import com.example.employeepayroll.model.Employee;
import com.example.employeepayroll.service.EmpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmpController {
    @Autowired
    EmpService empService;

    @PostMapping("/addEmployeeDto")
    public ResponseEntity<ResponseDto> addEmployeeDto(@Valid @RequestBody EmployeeDto employeeDto) {
        Employee employee=empService.addEmployeeDto(employeeDto);
        ResponseDto responseDto=new ResponseDto("new employee added successfully",employee);
        ResponseEntity<ResponseDto> response=new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

    @GetMapping("/getEmployee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return empService.getEmployee(id);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return empService.deleteEmployee(id);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<ResponseDto> updateEmployee(@Valid @PathVariable int id ,@RequestBody EmployeeDto emp){
        Employee employee = empService.updateEmployee(emp,id);
        ResponseDto responseDto = new ResponseDto(" Employee updated successfully",employee);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

    @GetMapping("/allPeople")
    public List<Employee> getAll(){
        return empService.getAllEmployeePeople();
    }

 //   @PutMapping("/updateEmployee/{id}")
//    public String updateEmployee(@PathVariable int id) {
//        return empService.updateEmployee(id);
//    }

//    @DeleteMapping("/deleteEmployeeDto/{id}")
//    public EmployeeDto deleteEmployeeDto(@PathVariable int id) {
//        return empService.deleteEmployeeDto(id);
//    }


//    @GetMapping("/getEmployeeDto/{id}")
//    public EmployeeDto getEmployeeDto(@PathVariable int id){
//        return empService.getEmployeeDto(id);
//    }

//
//    @DeleteMapping("deleteById/{id}")
//    public String deleteById(@PathVariable int id) {
//        return empService.deleteById(id);
//    }
//
//    @PutMapping("/updateById/{id}")
//    public EmployeeDto updateById(@PathVariable int id, @RequestBody EmployeeDto employeeDto){
//        return empService.updateById(id,employeeDto);
//    }
//
//    @GetMapping("/allPeople")
//    public List<EmployeeDto> getAll(){
//        return empService.getAllEmployeeDtoPeople();
//    }


}