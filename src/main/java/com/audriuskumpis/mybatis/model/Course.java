package com.audriuskumpis.mybatis.model;

public class Course {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COURSE.ID
     *
     * @mbg.generated Tue Apr 19 19:58:33 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COURSE.TITLE
     *
     * @mbg.generated Tue Apr 19 19:58:33 EEST 2022
     */
    private String title;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COURSE.ID
     *
     * @return the value of PUBLIC.COURSE.ID
     *
     * @mbg.generated Tue Apr 19 19:58:33 EEST 2022
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
     * @mbg.generated Tue Apr 19 19:58:33 EEST 2022
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
     * @mbg.generated Tue Apr 19 19:58:33 EEST 2022
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
     * @mbg.generated Tue Apr 19 19:58:33 EEST 2022
     */
    public void setTitle(String title) {
        this.title = title;
    }
}