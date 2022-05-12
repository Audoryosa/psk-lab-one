package com.audriuskumpis.usecases;

import com.audriuskumpis.entities.Student;
import com.audriuskumpis.persistence.StudentsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static javax.faces.context.FacesContext.getCurrentInstance;

@Named
@Getter
@Setter
@ViewScoped
public class UpdateStudentDetails implements Serializable {

    private Student student;

    @Inject
    private StudentsDAO studentsDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdatePlayerDetails INIT CALLED");
        Map<String, String> requestParams = getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();

        Integer studentId = parseInt(requestParams.get("studentId"));
        this.student = studentsDAO.findOne(studentId);
    }

    @Transactional
    public String updateStudentId() {
        try {
            studentsDAO.update(this.student);
        } catch (OptimisticLockException e) {
            return "/studentDetails.xhtml?faces-redirect=true&studentId=" + this.student.getId() + "&error=optimistic-lock-exception";
        }
        return "students.xhtml?courseId=" + this.student.getCourse().getId() + "&faces-redirect=true";
    }

}
