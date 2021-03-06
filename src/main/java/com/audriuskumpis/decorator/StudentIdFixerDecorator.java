package com.audriuskumpis.decorator;

import com.audriuskumpis.interceptors.Logger;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import static java.lang.Integer.parseInt;

@Decorator
public abstract class StudentIdFixerDecorator implements StudentIdFixer {

    @Inject
    @Delegate
    @Any
    private StudentIdFixer studentIdFixer;

    @Override
    @Logger
    public Integer fixStudentId(int id) {
        return parseInt(studentIdFixer.fixStudentId(id) + "999");
    }
}
