package com.lukasdtx.itman.controllers;

import com.lukasdtx.itman.dto.EmployeeDto;
import com.lukasdtx.itman.dto.EmployeeResponse;
import com.lukasdtx.itman.models.Employee;
import com.lukasdtx.itman.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public ResponseEntity<EmployeeResponse> getEmployees(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        return new ResponseEntity<>(employeeService.getAllEmployee(pageNo, pageSize), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> employeeDetail(@PathVariable int id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
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
