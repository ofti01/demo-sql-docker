package com.example.demosqldocker.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Student extends AbstractActivity{

    private String name;
    private String addresse;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


}
