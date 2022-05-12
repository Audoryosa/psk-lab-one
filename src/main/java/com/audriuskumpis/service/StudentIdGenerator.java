package com.audriuskumpis.service;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

@ApplicationScoped
public class StudentIdGenerator implements Serializable {

    @Futureable
    public Future<Integer> generateStudentId() {
        try {
            sleep(5 * 1000);
        } catch (InterruptedException e) {
        }
        final Integer generatedStudentId = new Random().nextInt(1000);
        return new AsyncResult<>(generatedStudentId);
    }
}
