package com.longder.science.service;

import com.longder.science.entity.po.Project;
import com.longder.science.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 项目管理的service
 */
@Service
public class ProjectManageService {
    @Resource
    private ProjectRepository projectRepository;

    /**
     * 查询所有项目
     *
     * @return
     */
    public List<Project> listAllProject() {
        List<Project> projectList = projectRepository.findAll();
        //处理展示用的教师姓名和学生姓名
        projectList.forEach(project -> {
            project.setStudentName(project.getStudent() != null ? project.getStudent().getName() : "");
            project.setTeacherName(project.getTeacher() != null ? project.getTeacher().getName() : "");
        });
        return projectList;
    }

    /**
     * 添加一个项目
     */
    @Transactional
    public void addOneProject(Project project) {
        projectRepository.save(project);
    }

    /**
     * 获取一个项目
     *
     * @return
     */
    public Project getOneProject(Long projectId) {
        Project project = projectRepository.getOne(projectId);
        project.setStudentName(project.getStudent() != null ? project.getStudent().getName() : "");
        project.setTeacherName(project.getTeacher() != null ? project.getTeacher().getName() : "");
        return project;
    }

    /**
     * 编辑一个项目
     *
     * @param project
     */
    @Transactional
    public void editOneProject(Project project) {
        projectRepository.save(project);
    }

    /**
     * 删除一个项目
     *
     * @param projectId
     */
    @Transactional
    public void removeOneProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }

}
