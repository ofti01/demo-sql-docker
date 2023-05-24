package com.example.demosqldocker.entities;

import com.example.demosqldocker.dtos.StudentDto;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Builder
public class Department extends AbstractActivity{

    private String nameDep;

    private String chef;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Student> students;

}
