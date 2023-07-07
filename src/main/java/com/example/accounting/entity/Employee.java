package com.example.accounting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Employee extends BaseEntity {
    public String Firstname;
    public String LastName;
    public Long pinfl;
   public LocalDateTime hireDate;
   @ManyToMany
    public Organization organization;



}
