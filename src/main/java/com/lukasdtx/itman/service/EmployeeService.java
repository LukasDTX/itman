package com.lukasdtx.itman.service;

import com.lukasdtx.itman.dto.EmployeeDto;
import com.lukasdtx.itman.dto.EmployeeResponse;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeResponse getAllEmployee(int pageNo, int pageSize);
    EmployeeDto getEmployeeById(int id);
    EmployeeDto updateEmployee(EmployeeDto employeeDto, int id);
    void deleteEmployeeId(int id);
}
