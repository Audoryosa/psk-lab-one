package com.audriuskumpis.usecases;

import com.audriuskumpis.entities.Course;
import com.audriuskumpis.entities.Instructor;
import com.audriuskumpis.entities.Student;
import com.audriuskumpis.persistence.CoursesDAO;
import com.audriuskumpis.persistence.InstructorsDAO;
import com.audriuskumpis.persistence.StudentsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static javax.faces.context.FacesContext.getCurrentInstance;

@Model
public class StudentsForCourse implements Serializable {

    @Inject
    private CoursesDAO coursesDAO;

    @Inject
    private StudentsDAO studentsDAO;

    @Inject
    private InstructorsDAO instructorsDAO;

    @Getter
    @Setter
    private Course course;

    @Getter
    @Setter
    private Student studentToCreate = new Student();

    @Getter
    @Setter
    private Instructor instructorToAdd = new Instructor();

    @Transactional
    public String createStudent() {
        studentToCreate.setCourse(this.course);
        studentsDAO.persist(studentToCreate);
        return "students?faces-redirect=true&courseId=" + this.course.getId();
    }

    @Transactional
    public String createInstructor() {
        Instructor foundInstructor = instructorsDAO.findByName(instructorToAdd.getName());
        if (isNull(foundInstructor)) {
            handleNewInstructor();
        } else {
            handleExistingInstructor(foundInstructor);
        }

        return "index?faces-redirect=true";
    }

    private void handleExistingInstructor(Instructor foundInstructor) {
        instructorToAdd.setId(foundInstructor.getId());
        List<Course> allInstructorCourses = foundInstructor.getCourses();
        allInstructorCourses.add(this.course);
        instructorToAdd.setCourses(allInstructorCourses);
        instructorsDAO.update(instructorToAdd);
    }

    private void handleNewInstructor() {
        List<Course> allInstructorCourses = new ArrayList<>();
        allInstructorCourses.add(this.course);
        instructorToAdd.setCourses(allInstructorCourses);
        instructorsDAO.persist(instructorToAdd);
    }

    @PostConstruct
    private void init() {
        Map<String, String > requestParams = getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();

        int courseId = Integer.parseInt(requestParams.get("courseId"));
        this.course = coursesDAO.findOne(courseId);
    }
}
