package com.audriuskumpis.rest;

import com.audriuskumpis.decorator.StudentIdFixer;
import com.audriuskumpis.entities.Course;
import com.audriuskumpis.entities.Student;
import com.audriuskumpis.persistence.CoursesDAO;
import com.audriuskumpis.persistence.StudentsDAO;
import com.audriuskumpis.rest.resource.StudentDto;
import com.audriuskumpis.service.DefaultValidator;
import com.audriuskumpis.service.NameValidator;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import java.net.URI;

import static java.net.URI.create;
import static java.util.Objects.isNull;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.*;
import static javax.ws.rs.core.Response.Status.CONFLICT;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@ApplicationScoped
@Path("/students")
public class StudentsController {

    @Inject
    @Getter
    @Setter
    private StudentsDAO studentsDAO;

    @Inject
    private NameValidator validator;

    @Inject
    private DefaultValidator defaultValidator;

    @Inject
    private StudentIdFixer idFixer;

    @Inject
    private CoursesDAO coursesDAO;

    @Context
    private UriInfo servletRequest;

    @POST
    @Transactional
    @Produces(APPLICATION_JSON)
    public Response createStudent(StudentDto studentDto) {
        Course course = coursesDAO.findByName(studentDto.getCourseName());
        Student studentToCreate = mapStudentToEntity(studentDto, course);
        studentsDAO.persist(studentToCreate);
        final String createdUri = servletRequest.getAbsolutePath() + "/" + studentToCreate.getId();
        return created(create(createdUri)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
        Student student = studentsDAO.findOne(id);
        if (isNull(student)) {
            return status(NOT_FOUND).build();
        }
        StudentDto studentDto = new StudentDto(student.getFullName(), student.getStudentId(), student.getCourse().getTitle());
        return ok(studentDto).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") Integer id, StudentDto studentDto) {
        try {
            Student existingStudent = studentsDAO.findOne(id);
            if (isNull(existingStudent)) {
                return status(NOT_FOUND).build();
            }
            boolean nameValid = defaultValidator.isNameValid(studentDto.getFullName());
            boolean nameValid2 = validator.isNameValid(studentDto.getFullName());

            existingStudent.setFullName(studentDto.getFullName());
            existingStudent.setStudentId(idFixer.fixStudentId(studentDto.getStudentId()));
            studentsDAO.update(existingStudent);
            return ok().build();
        } catch (OptimisticLockException e) {
            return status(CONFLICT).build();
        }
    }

    private Student mapStudentToEntity(StudentDto studentDto, Course course) {
        Student studentToCreate = new Student();
        studentToCreate.setStudentId(studentDto.getStudentId());
        studentToCreate.setFullName(studentDto.getFullName());
        studentToCreate.setCourse(course);
        return studentToCreate;
    }
}
