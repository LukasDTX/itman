package com.lukasdtx.itman.controllers;

import com.lukasdtx.itman.models.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Marek", "Nowak"));
        employees.add(new Employee(2, "Maria", "Kowal"));
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/{id}")
    public Employee employeeDetail(@PathVariable int id){
        return new Employee (id,"Marek", "Nowak");
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        System.out.println(employee.getFirstName());
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        System.out.println("employee update");
        return ResponseEntity.ok(employee);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
        System.out.println("employee deleted");
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
