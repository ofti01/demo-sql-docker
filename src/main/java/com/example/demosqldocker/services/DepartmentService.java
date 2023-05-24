package com.example.demosqldocker.services;

import com.example.demosqldocker.dtos.DepartmentDto;
import com.example.demosqldocker.entities.Department;
import com.example.demosqldocker.exceptions.ResourceNotFound;
import com.example.demosqldocker.repositories.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Slf4j
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<DepartmentDto> findAll(){
        log.debug("Request to get All departments");
        return departmentRepository.findAll()
                .stream()
                .map(DepartmentService::mapToDto)
                .collect(Collectors.toList());
    }

    public DepartmentDto saveDepartment(DepartmentDto departmentDto){
        log.debug("Request to create departement: {}",departmentDto);
        return mapToDto(departmentRepository.save(new Department(
                departmentDto.getNameDep(),
                departmentDto.getChef(),
                departmentDto.getStudentDtos().stream().map(StudentService::mapFromDto).collect(Collectors.toList())
        )));
    }

    @Transactional(readOnly = true)
    public DepartmentDto findById(long id){
        log.debug("Request to get department:{}",id);
        return departmentRepository.findById(id).map(DepartmentService::mapToDto).orElseThrow(
                () -> new ResourceNotFound("User with "+id+"Not found")
        );
    }

    public DepartmentDto updateDepartment(DepartmentDto departmentDto){
        log.debug("Request to update department:{}",departmentDto.getId());
        if(departmentRepository.findById(departmentDto.getId()).isPresent()){
            return saveDepartment(departmentDto);
        }
        else return null;
    }

    public void deleteDepartment(Long id){
        log.debug("Request to delete department:{}",id);
    }


    public static DepartmentDto mapToDto(Department department){
        if(department == null) return null;
        else return
                DepartmentDto.builder()
                        .id(department.getId())
                        .nameDep(department.getNameDep())
                        .chef(department.getChef())
                        .studentDtos(department.getStudents().stream().map(StudentService::mapToDto).collect(Collectors.toList()))
                        .build();
    }

}
