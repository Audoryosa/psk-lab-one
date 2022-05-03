package com.audriuskumpis.mybatis.dao;

import com.audriuskumpis.mybatis.model.Instructor;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface InstructorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.INSTRUCTOR
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.INSTRUCTOR
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    int insert(Instructor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.INSTRUCTOR
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    Instructor selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.INSTRUCTOR
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    List<Instructor> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.INSTRUCTOR
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    int updateByPrimaryKey(Instructor record);

    Instructor findByName(String name);
}