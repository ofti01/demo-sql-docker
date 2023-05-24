package com.example.demosqldocker.services;

import com.example.demosqldocker.dtos.StudentDto;
import com.example.demosqldocker.entities.Student;
import com.example.demosqldocker.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;

    public static StudentDto mapToDto(Student student) {
        return null;
    }

    public static Student mapFromDto(StudentDto studentDto) {
        return null;
    }
}
