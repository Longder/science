package com.longder.science.controller;

import com.longder.science.entity.po.Teacher;
import com.longder.science.service.TeacherManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin/teacher")
@Slf4j
public class TeacherController {
    @Resource
    private TeacherManageService teacherManageService;
    /**
     * 教师列表
     * @return
     */
    @GetMapping("/list")
    public String teacherList(Model model){
        model.addAttribute("list",teacherManageService.listAllTeacher());
        return "teacher/list";
    }

    /**
     * 去添加教师的页面
     * @return
     */
    @GetMapping("/toAdd")
    public String toAddTeacher(){
        return "teacher/add-teacher-modal";
    }

    /**
     * 添加教师
     * @return
     */
    @PostMapping("/add")
    public String addTeacher(Teacher teacher){
        log.info("添加教师");
        teacherManageService.addOneTeacher(teacher);
        return "redirect:list";
    }

    /**
     * 去修改教师
     * @return
     */
    @GetMapping("/toEdit")
    public String toEditTeacher(Long teacherId,Model model){
        log.info("去修改教师，教师id:{}",teacherId);
        model.addAttribute("teacher",teacherManageService.getOneTeacher(teacherId));
        return "teacher/edit-teacher-modal";
    }

    /**
     * 修改教师
     * @param teacher
     * @return
     */
    @PostMapping("/edit")
    public String editTeacher(Teacher teacher){
        log.info("修改教师！");
        teacherManageService.editOneTeacher(teacher);
        return "redirect:list";
    }

    /**
     * 删除教师
     * @param teacherId
     * @return
     */
    @GetMapping("/remove")
    public String removeTeacher(Long teacherId){
        log.info("删除教师，教师id:{}",teacherId);
        teacherManageService.removeOneTeacher(teacherId);
        return "redirect:list";
    }
}
