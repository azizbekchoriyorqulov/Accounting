package com.example.accounting.service;

import com.example.accounting.dto.EmployeeRequestDto;
import com.example.accounting.entity.Employee;
import com.example.accounting.entity.Organization;
import com.example.accounting.exception.AuthenticationFailedException;
import com.example.accounting.exception.DataNotFoundException;
import com.example.accounting.exception.UniqueObjectException;
import com.example.accounting.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class OrganizationService {
    private final OrganizationRepository organizationRepository;
    public Organization save(Organization organization){

        if (organizationRepository.findEmployeesByName(organization.getName()) != null) {
            return organizationRepository.save(organization);
        }
        throw new UniqueObjectException("Organization already exists");
    }
    public void delete (UUID id){
        Organization organization = organizationRepository.findById(id).orElseThrow(
                ()->new DataNotFoundException("organization not found by id")
        );

    }
    public Organization update(Organization update, UUID employeeId) {
        Organization organizarion = organizationRepository.findById(employeeId).orElseThrow(() -> new AuthenticationFailedException("Organization not found"));

        if (update.getName() != null) {
            organizarion.setName(update.getName());
        }
        if (update.getRegion() != null) {
            organizarion.setRegion(update.getRegion());
        }

        if (update.parent != null) {
            organizarion.setParent(update.getParent());
        }
        return organizationRepository.save(organizarion);
    }
}
