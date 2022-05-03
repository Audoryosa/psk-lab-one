package com.audriuskumpis.usecases.mybatis;

import com.audriuskumpis.mybatis.dao.CourseMapper;
import com.audriuskumpis.mybatis.model.Course;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class CoursesMyBatis implements Serializable {

    @Inject
    private CourseMapper coursesMapper;

    @Getter
    private List<Course> allCourses;

    @Getter
    @Setter
    private Course courseToCreate = new Course();

    @PostConstruct
    private void init() {
        loadAllCourses();
    }

    @Transactional
    public String createCourse() {
        coursesMapper.insert(courseToCreate);
        return "/myBatis/courses?faces-redirect=true";
    }

    private void loadAllCourses() {
        allCourses = coursesMapper.selectAll();
    }
}
