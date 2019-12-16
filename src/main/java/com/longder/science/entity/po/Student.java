package com.longder.science.entity.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

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

}
