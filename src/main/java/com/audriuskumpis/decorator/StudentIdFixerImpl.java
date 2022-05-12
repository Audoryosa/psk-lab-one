package com.audriuskumpis.decorator;

import com.audriuskumpis.interceptors.Logger;

import javax.enterprise.context.ApplicationScoped;

import static java.lang.Integer.parseInt;

@ApplicationScoped
public class StudentIdFixerImpl implements StudentIdFixer {
    @Override
    @Logger
    public Integer fixStudentId(int id) {
        return parseInt(id + "222");
    }
}
