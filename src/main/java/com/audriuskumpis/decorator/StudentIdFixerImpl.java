package com.audriuskumpis.decorator;

import javax.enterprise.context.ApplicationScoped;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

@ApplicationScoped
public class StudentIdFixerImpl implements StudentIdFixer {
    @Override
    public Integer fixStudentId(int id) {
        return parseInt(id + "222");
    }
}
