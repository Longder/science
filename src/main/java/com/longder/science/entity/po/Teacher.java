package com.longder.science.entity.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 教师
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "TEACHER")
public class Teacher extends BaseIdEntity {
    /**
     * 姓名
     */
    @Column(name = "name_")
    private String name;
    /**
     * 性别
     */
    @Column(name = "sex_")
    private String sex;

    /**
     * 年龄
     */
    @Column(name = "age_")
    private Integer age;

    /**
     * 职称
     */
    @Column(name = "level_")
    private String level;
}
