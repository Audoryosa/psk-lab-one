package com.audriuskumpis.persistence.mybatis.model;

public class Course {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COURSE.ID
     *
     * @mbg.generated Mon Apr 18 18:49:12 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COURSE.TITLE
     *
     * @mbg.generated Mon Apr 18 18:49:12 EEST 2022
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COURSE.STUDENT_ID
     *
     * @mbg.generated Mon Apr 18 18:49:12 EEST 2022
     */
    private Integer studentId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COURSE.ID
     *
     * @return the value of PUBLIC.COURSE.ID
     *
     * @mbg.generated Mon Apr 18 18:49:12 EEST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COURSE.ID
     *
     * @param id the value for PUBLIC.COURSE.ID
     *
     * @mbg.generated Mon Apr 18 18:49:12 EEST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COURSE.TITLE
     *
     * @return the value of PUBLIC.COURSE.TITLE
     *
     * @mbg.generated Mon Apr 18 18:49:12 EEST 2022
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COURSE.TITLE
     *
     * @param title the value for PUBLIC.COURSE.TITLE
     *
     * @mbg.generated Mon Apr 18 18:49:12 EEST 2022
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COURSE.STUDENT_ID
     *
     * @return the value of PUBLIC.COURSE.STUDENT_ID
     *
     * @mbg.generated Mon Apr 18 18:49:12 EEST 2022
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COURSE.STUDENT_ID
     *
     * @param studentId the value for PUBLIC.COURSE.STUDENT_ID
     *
     * @mbg.generated Mon Apr 18 18:49:12 EEST 2022
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}