package com.audriuskumpis.usecases.mybatis;

import com.audriuskumpis.mybatis.dao.CourseMapper;
import com.audriuskumpis.mybatis.dao.InstructedCourseMapper;
import com.audriuskumpis.mybatis.dao.InstructorMapper;
import com.audriuskumpis.mybatis.model.Course;
import com.audriuskumpis.mybatis.model.InstructedCourse;
import com.audriuskumpis.mybatis.model.Instructor;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

import static javax.faces.context.FacesContext.getCurrentInstance;

@Model
public class StudentsForCourseMyBatis implements Serializable {

    @Inject
    private CourseMapper courseMapper;

    @Inject
    private InstructorMapper instructorMapper;

    @Inject
    private InstructedCourseMapper instructedCourseMapper;

    @Getter
    @Setter
    private Course course;

    @Getter
    @Setter
    private Instructor instructorToAdd = new Instructor();

    @Transactional
    public String addInstructorForCourse() {
        instructorMapper.insert(instructorToAdd);
        Instructor createdInstructor = instructorMapper.findByName(instructorToAdd.getName());
        InstructedCourse instructedCourse = new InstructedCourse();
        instructedCourse.setCourseId(this.course.getId());
        instructedCourse.setInstructorId(createdInstructor.getId());
        instructedCourseMapper.insert(instructedCourse);
        return "courses?faces-redirect=true";
    }

    @PostConstruct
    private void init() {
        Map<String, String > requestParams = getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();

        int courseId = Integer.parseInt(requestParams.get("courseId"));
        this.course = courseMapper.selectByPrimaryKey(courseId);
    }
}
