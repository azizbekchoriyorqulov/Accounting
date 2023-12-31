package com.example.accounting.repository;

import com.example.accounting.entity.CalculationTable;
import com.example.accounting.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CalculationTableRepository extends JpaRepository <CalculationTable, UUID> {
    CalculationTable findEmployeesByEmployee(Employee employee);

}

