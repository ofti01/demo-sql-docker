package com.example.demosqldocker.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class DepartmentDto {
    private Long id;
    private String nameDep;
    private String chef;
    private List<StudentDto> studentDtos;
}
