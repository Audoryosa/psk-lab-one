package com.audriuskumpis.rest;

import com.audriuskumpis.decorator.StudentIdFixer;
import com.audriuskumpis.entities.Student;
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
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static java.util.Objects.isNull;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.CONFLICT;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;

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
            if (!defaultValidator.isNameValid(studentDto.getFullName())) {
                System.err.println(defaultValidator.getClass().getSimpleName() + " says name is not valid");
            }
            if (!validator.isNameValid(studentDto.getFullName())) {
                System.err.println(validator.getClass().getSimpleName() + " says name is not valid");
            }

            existingStudent.setFullName(studentDto.getFullName());
            existingStudent.setStudentId(idFixer.fixStudentId(studentDto.getStudentId()));
            studentsDAO.update(existingStudent);
            return ok().build();
        } catch (OptimisticLockException e) {
            return status(CONFLICT).build();
        }
    }
}
