package com.longder.science.service;

import com.longder.science.entity.po.Project;
import com.longder.science.entity.po.Teacher;
import com.longder.science.repository.ProjectRepository;
import com.longder.science.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 教师管理的service
 */
@Service
public class TeacherManageService {

    @Resource
    private TeacherRepository teacherRepository;

    @Resource
    private ProjectRepository projectRepository;

    /**
     * 查询所有教师
     * @return
     */
    public List<Teacher> listAllTeacher(){
        return teacherRepository.findAll();
    }

    /**
     * 存储一个教师
     */
    @Transactional
    public void addOneTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    /**
     * 获取一个教师
     * @param teacherId
     * @return
     */
    public Teacher getOneTeacher(Long teacherId){
        return teacherRepository.getOne(teacherId);
    }

    /**
     * 编辑一个老师
     * @param teacher
     */
    @Transactional
    public void editOneTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    /**
     * 删除一个教师
     * @param teacherId
     */
    @Transactional
    public void removeOneTeacher(Long teacherId){
        //检查教师关联的project，清空教师id
        List<Project> projectList = projectRepository.listByTeacherId(teacherId);
        projectList.forEach(project -> project.setTeacher(null));
        projectRepository.saveAll(projectList);
        teacherRepository.deleteById(teacherId);
    }

}
