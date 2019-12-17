package com.longder.science.controller;

import com.longder.science.entity.po.Student;
import com.longder.science.service.StudentManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin/student")
@Slf4j
public class StudentController {

    @Resource
    private StudentManageService studentManageService;

    /**
     * 学生列表
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String studentList(Model model){
        model.addAttribute("list",studentManageService.listAllStudent());
        return "student/list";
    }

    /**
     * 去添加学生页面
     * @return
     */
    @GetMapping("/toAdd")
    public String toAddStudent(){
        return "student/add-student-modal";
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    @PostMapping("/add")
    public String addStudent(Student student){
        log.info("添加学生");
        studentManageService.addOneStudent(student);
        return "redirect:list";
    }

    /**
     * 去修改学生
     * @param studentId
     * @param model
     * @return
     */
    @GetMapping("/toEdit")
    public String toEditStudent(Long studentId,Model model){
        model.addAttribute("student",studentManageService.getOneStudent(studentId));
        return "student/edit-student-modal";
    }

    /**
     * 修改学生
     * @param student
     * @return
     */
    @PostMapping("/edit")
    public String editStudent(Student student){
        studentManageService.editOneStudent(student);
        return "redirect:list";
    }

    /**
     * 删除学生
     * @param studentId
     * @return
     */
    @GetMapping("/remove")
    public String removeStudent(Long studentId){
        studentManageService.removeOneStudent(studentId);
        return "redirect:list";
    }

}
