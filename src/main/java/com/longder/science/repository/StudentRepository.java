package com.longder.science.repository;

import com.longder.science.entity.po.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
