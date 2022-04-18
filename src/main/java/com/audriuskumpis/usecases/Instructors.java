package com.audriuskumpis.usecases;

import com.audriuskumpis.entities.Instructor;
import com.audriuskumpis.persistence.InstructorsDAO;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Model
public class Instructors implements Serializable {

    @Inject
    private InstructorsDAO dao;

    @Getter
    private List<Instructor> allInstructors;

    @PostConstruct
    private void init() {
        loadAllInstructors();
    }

    private void loadAllInstructors() {
        allInstructors = dao.findAll();
    }


}
