package com.example.accounting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Employee extends BaseEntity {
    public String firstname;
    public String lastName;
    public Long pinfl;
    @CreationTimestamp
   public LocalDateTime hireDate;
   @ManyToOne
    public Organization organization;



}
