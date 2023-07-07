package com.example.accounting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;


@Entity(name = "organization")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Organization extends BaseEntity {
    public String name;
    @ManyToOne
    public Region region;
    @ManyToOne
public Organization parent;
}
