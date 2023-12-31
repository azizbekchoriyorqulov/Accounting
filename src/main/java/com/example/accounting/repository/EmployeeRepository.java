package com.example.accounting.repository;

import com.example.accounting.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    Optional<Employee> findEmployeesByPinfl(String pinfl);

}
