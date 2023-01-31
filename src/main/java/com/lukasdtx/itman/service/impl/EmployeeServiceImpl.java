package com.lukasdtx.itman.service.impl;

import com.lukasdtx.itman.dto.EmployeeDto;
import com.lukasdtx.itman.dto.EmployeeResponse;
import com.lukasdtx.itman.exceptions.EmployeeNotFoundException;
import com.lukasdtx.itman.models.Employee;
import com.lukasdtx.itman.repository.EmployeeRepository;
import com.lukasdtx.itman.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());

        Employee newEmployee = employeeRepository.save(employee);

        EmployeeDto employeeResponse = new EmployeeDto();
        employeeResponse.setIdEmployee(newEmployee.getIdEmployee());
        employeeResponse.setFirstName(newEmployee.getFirstName());
        employeeResponse.setLastName(newEmployee.getLastName());
        return employeeResponse;
    }

    @Override
    public EmployeeResponse getAllEmployee(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Employee> employees = employeeRepository.findAll(pageable);
        List<Employee> listOfEmployee = employees.getContent();
        List<EmployeeDto> content = listOfEmployee.stream().map(p -> mapToDto(p)).collect(Collectors.toList());

        EmployeeResponse pokemonResponse = new EmployeeResponse();
        pokemonResponse.setContent(content);
        pokemonResponse.setPageNo(employees.getNumber());
        pokemonResponse.setPageSize(employees.getSize());
        pokemonResponse.setTotalElements(employees.getTotalElements());
        pokemonResponse.setTotalPages(employees.getTotalPages());
        pokemonResponse.setLast(employees.isLast());

        return pokemonResponse;
    }

    @Override
    public EmployeeDto getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee could not be found"));
        return mapToDto(employee);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, int id) {
        return null;
    }

    @Override
    public void deleteEmployeeId(int id) {

    }
    private EmployeeDto mapToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setIdEmployee(employee.getIdEmployee());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        return employeeDto;
    }

    private Employee mapToEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        return employee;
    }
}
