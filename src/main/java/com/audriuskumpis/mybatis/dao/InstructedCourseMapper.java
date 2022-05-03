package com.audriuskumpis.mybatis.dao;

import com.audriuskumpis.mybatis.model.InstructedCourse;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface InstructedCourseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.INSTRUCTED_COURSE
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    int insert(InstructedCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.INSTRUCTED_COURSE
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    List<InstructedCourse> selectAll();
}