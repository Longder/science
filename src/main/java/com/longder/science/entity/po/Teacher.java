package com.longder.science.entity.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
}
