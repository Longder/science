package com.longder.science.repository;

import com.longder.science.entity.po.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
