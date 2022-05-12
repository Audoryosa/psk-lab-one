package com.audriuskumpis.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@Alternative
@ApplicationScoped
public class VipValidator implements NameValidator {

    @Override
    public boolean isNameValid(String name) {
        return name.length() < 15;
    }
}
