package com.example.accounting.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity(name = "region")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Region extends BaseEntity {
    public String name;
}
