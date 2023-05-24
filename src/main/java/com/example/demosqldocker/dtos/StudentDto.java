package com.example.demosqldocker.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    private Long id;
    private String name;
    private String addresse;
    private DepartmentDto departmentDto;
}
