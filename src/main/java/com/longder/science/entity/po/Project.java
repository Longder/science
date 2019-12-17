package com.longder.science.entity.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "PROJECT")
public class Project extends BaseIdEntity {
    /**
     * 名称
     */
    @Column(name = "name_")
    private String name;

    /**
     * 描述
     */
    @Column(name = "describe_")
    private String describe;

    /**
     * 关联学生
     */
    @OneToOne
    @JoinColumn(name = "student_id_")
    private Student student;

    /**
     * 关联教师
     */
    @ManyToOne
    @JoinColumn(name = "teacher_id_")
    private Teacher teacher;

    /**
     * 学生姓名，展示用
     */
    @Transient
    private String studentName;

    /**
     * 教师姓名，展示用
     */
    @Transient
    private String teacherName;
}
