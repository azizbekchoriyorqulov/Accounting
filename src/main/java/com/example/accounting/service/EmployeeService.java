package com.example.accounting.service;

import com.example.accounting.dto.EmployeeRequestDto;
import com.example.accounting.entity.Employee;
import com.example.accounting.exception.AuthenticationFailedException;
import com.example.accounting.exception.DataNotFoundException;
import com.example.accounting.exception.UniqueObjectException;
import com.example.accounting.repository.EmployeeRepository;
import com.example.accounting.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;
    private final OrganizationRepository organizationRepository;


    public Employee save(EmployeeRequestDto employeeRequestDto) {
        Employee employee = modelMapper.map(employeeRequestDto, Employee.class);
        if (employeeRepository.findEmployeesByPinfl(employeeRequestDto.getPinfl()).isEmpty()) {
            employee.setHireDate(LocalDateTime.now());
            return employeeRepository.save(employee);
        }
        throw new UniqueObjectException("Employee already exists");
    }

    public void delete(UUID employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new DataNotFoundException("Employee not found"));
        employeeRepository.deleteById(employeeId);
    }
    public Employee getByID(UUID employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(
                () -> new DataNotFoundException("Employee not found"));
    }

    public Employee update(EmployeeRequestDto employeeRequestDto, UUID employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new AuthenticationFailedException("Employee not found"));

        if (employeeRequestDto.getFirstname() != null) {
            employee.setFirstname(employeeRequestDto.getFirstname());
        }
        if (employeeRequestDto.getLastName() != null) {
            employee.setLastName(employeeRequestDto.getLastName());
        }
        if(employeeRequestDto.getOrganizationId() != null) {
            employee.setOrganization(organizationRepository.findById(employeeRequestDto.getOrganizationId())
                    .orElseThrow(() -> new DataNotFoundException("Organization not found")));
        }
        if (employeeRequestDto.getPinfl() != null) {
            employee.setPinfl(employeeRequestDto.getPinfl());
        }
        return employeeRepository.save(employee);
    }

}