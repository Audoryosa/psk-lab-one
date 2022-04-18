package com.audriuskumpis.usecases;

import com.audriuskumpis.mybatis.dao.InstructorMapper;
import com.audriuskumpis.persistence.mybatis.model.Instructor;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Model
public class InstructorsMyBatis implements Serializable {

    @Inject
    private InstructorMapper mapper;

    @Getter
    private List<Instructor> allInstructors;

    @PostConstruct
    private void init() {
        loadAllInstructors();
    }

    private void loadAllInstructors() {
        allInstructors = mapper.selectAll();
    }
}
