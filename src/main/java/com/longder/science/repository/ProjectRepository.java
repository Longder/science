package com.longder.science.repository;

import com.longder.science.entity.po.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Query("SELECT P FROM Project P where P.student.id = :studentId")
    List<Project> listByStudentId(@Param("studentId") Long studentId);

    @Query("SELECT P FROM Project P where P.teacher.id = :teacherId")
    List<Project> listByTeacherId(@Param("teacherId")Long teacherId);
}
