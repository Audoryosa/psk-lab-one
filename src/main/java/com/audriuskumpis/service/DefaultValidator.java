package com.audriuskumpis.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@Alternative
@ApplicationScoped
public class DefaultValidator implements NameValidator {

    @Override
    public boolean isNameValid(String name) {
        return name.length() < 10;
    }
}
