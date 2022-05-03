package com.audriuskumpis.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Course {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COURSE.ID
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COURSE.TITLE
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    private String title;

    private List<Student> students;

    private List<Instructor> instructors;
}