package com.audriuskumpis.usecases;

import com.audriuskumpis.interceptors.Logger;
import com.audriuskumpis.service.StudentIdGenerator;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static javax.faces.context.FacesContext.getCurrentInstance;

@Named
@SessionScoped
public class GenerateStudentId implements Serializable {

    @Inject
    private StudentIdGenerator generator;

    private Future<Integer> generationTask = null;

    @Logger
    public String generateNewStudentId() {
        Map<String, String> requestParams = getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();

        generationTask = generator.generateStudentId();
        return "studentDetails.xhtml?faces-redirect=true&studentId=" + requestParams.get("studentId");
    }

    public boolean isGenerationRunning() {
        return nonNull(generationTask) && !generationTask.isDone();
    }

    public String getGenerationStatus() throws ExecutionException, InterruptedException {
        if (isNull(generationTask)) {
            return null;
        } else if (isGenerationRunning()) {
            return "Generation is in progress";
        }
        return "Generated Student ID: " + generationTask.get();
    }
}
