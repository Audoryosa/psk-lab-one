package com.audriuskumpis.mybatis.model;

public class InstructedCourse {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.INSTRUCTED_COURSE.INSTRUCTOR_ID
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    private Integer instructorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.INSTRUCTED_COURSE.COURSE_ID
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    private Integer courseId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.INSTRUCTED_COURSE.INSTRUCTOR_ID
     *
     * @return the value of PUBLIC.INSTRUCTED_COURSE.INSTRUCTOR_ID
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    public Integer getInstructorId() {
        return instructorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.INSTRUCTED_COURSE.INSTRUCTOR_ID
     *
     * @param instructorId the value for PUBLIC.INSTRUCTED_COURSE.INSTRUCTOR_ID
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.INSTRUCTED_COURSE.COURSE_ID
     *
     * @return the value of PUBLIC.INSTRUCTED_COURSE.COURSE_ID
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.INSTRUCTED_COURSE.COURSE_ID
     *
     * @param courseId the value for PUBLIC.INSTRUCTED_COURSE.COURSE_ID
     *
     * @mbg.generated Mon May 02 20:18:14 EEST 2022
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}