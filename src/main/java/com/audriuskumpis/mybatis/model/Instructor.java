package com.audriuskumpis.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Instructor {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.INSTRUCTOR.ID
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.INSTRUCTOR.NAME
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.INSTRUCTOR.ID
     *
     * @return the value of PUBLIC.INSTRUCTOR.ID
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.INSTRUCTOR.ID
     *
     * @param id the value for PUBLIC.INSTRUCTOR.ID
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.INSTRUCTOR.NAME
     *
     * @return the value of PUBLIC.INSTRUCTOR.NAME
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.INSTRUCTOR.NAME
     *
     * @param name the value for PUBLIC.INSTRUCTOR.NAME
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    public void setName(String name) {
        this.name = name;
    }

    public List<Course> courses;
}