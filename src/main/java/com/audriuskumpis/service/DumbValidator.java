package com.audriuskumpis.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

@Specializes
@ApplicationScoped
public class DumbValidator extends DefaultValidator {
    @Override
    public boolean isNameValid(String name) {
        return name.length() == 5;
    }
}
