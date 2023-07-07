package com.example.accounting.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "calculation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CalculationTable  extends BaseEntity{
public  double amount;
@OneToOne
public Employee employee;
public float rate;
@ManyToOne
public Organization organization;
@Enumerated(EnumType.STRING)
public CalculationType taype;
}
