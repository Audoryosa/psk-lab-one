package com.audriuskumpis.usecases;

import com.audriuskumpis.entities.Course;
import com.audriuskumpis.persistence.CoursesDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class Courses implements Serializable {

    @Inject
    private CoursesDAO coursesDAO;

    @Getter
    @Setter
    private Course courseToCreate = new Course();

    @Getter
    private List<Course> allCourses;

    @PostConstruct
    private void init() {
        loadAllCourses();
    }

    @Transactional
    public String createCourse() {
        coursesDAO.persist(courseToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllCourses() {
        this.allCourses = coursesDAO.loadAll();
    }
}
