package com.example.demosqldocker.repositories;

import com.example.demosqldocker.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
