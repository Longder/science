package com.longder.science.service;

import com.longder.science.entity.po.Student;
import com.longder.science.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学生管理的service
 */
@Service
public class StudentManageService {

    @Resource
    private StudentRepository studentRepository;

    /**
     * 查询所有学生
     * @return
     */
    public List<Student> listAllStudent(){
        return studentRepository.findAll();
    }

    /**
     * 存储一个学生
     * @param student
     */
    @Transactional
    public void addOneStudent(Student student){
        studentRepository.save(student);
    }

    /**
     * 获取一个学生
     * @param studentId
     * @return
     */
    public Student getOneStudent(Long studentId){
        return studentRepository.getOne(studentId);
    }

    /**
     * 编辑一个学生
     * @param student
     */
    @Transactional
    public void editOneStudent(Student student){
        studentRepository.save(student);
    }

    /**
     * 删除一个学生
     * @param studentId
     */
    @Transactional
    public void removeOneStudent(Long studentId){
        studentRepository.deleteById(studentId);
    }
}
