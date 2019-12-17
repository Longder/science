package com.longder.science.controller;

import com.longder.science.entity.po.Project;
import com.longder.science.service.ProjectManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin/project")
@Slf4j
public class ProjectController {
    @Resource
    private ProjectManageService projectManageService;

    /**
     * 项目列表
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String projectList(Model model){
        model.addAttribute("list",projectManageService.listAllProject());
        return "project/list";
    }

    /**
     * 去添加项目页面
     * @param model
     * @return
     */
    @GetMapping("/toAdd")
    public String toAddProject(Model model){
        return "project/add-project-modal";
    }

    /**
     * 添加项目
     * @param project
     * @return
     */
    @PostMapping("/add")
    public String addProject(Project project){
        projectManageService.addOneProject(project);
        return "redirect:list";
    }

    /**
     * 去编辑项目
     * @param projectId
     * @param model
     * @return
     */
    @GetMapping("/toEdit")
    public String toEditProject(Long projectId,Model model){
        return "project/edit-project-modal";
    }

    /**
     * 编辑项目
     * @return
     */
    @PostMapping("/edit")
    public String editProject(Project project){
        projectManageService.editOneProject(project);
        return "redirect:list";
    }

    /**
     * 删除项目
     * @return
     */
    @GetMapping("/remove")
    public String removeProject(Long projectId){
        projectManageService.removeOneProject(projectId);
        return "redirect:list";
    }
}
