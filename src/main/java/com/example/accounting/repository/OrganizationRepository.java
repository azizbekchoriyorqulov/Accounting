package com.example.accounting.repository;

import com.example.accounting.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrganizationRepository extends JpaRepository<Organization, UUID> {
    public Organization findEmployeesByName(String name);
}
