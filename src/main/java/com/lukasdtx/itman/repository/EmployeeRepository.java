package com.lukasdtx.itman.repository;

import com.lukasdtx.itman.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
