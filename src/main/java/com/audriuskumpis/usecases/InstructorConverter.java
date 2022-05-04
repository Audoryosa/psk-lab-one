package com.audriuskumpis.usecases;

import com.audriuskumpis.entities.Instructor;
import com.audriuskumpis.persistence.InstructorsDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

@ManagedBean
@RequestScoped
public class InstructorConverter implements Converter {

    @Inject
    private InstructorsDAO instructorsDAO;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }
        return instructorsDAO.findByName(submittedValue);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o == null) {
            return "";
        }
        if (o instanceof Instructor) {
            return ((Instructor) o).getName();
        }
        return "";
    }
}
