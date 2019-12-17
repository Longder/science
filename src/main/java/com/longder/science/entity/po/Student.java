package com.longder.science.entity.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 学生
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "STUDENT")
public class Student extends BaseIdEntity{
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
     * 学号
     */
    @Column(name = "number_")
    private String number;

}
