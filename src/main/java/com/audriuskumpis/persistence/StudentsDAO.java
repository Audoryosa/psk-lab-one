package com.audriuskumpis.persistence;

import com.audriuskumpis.entities.Student;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class StudentsDAO {

    @Setter
    @Inject
    private EntityManager entityManager;

    public void persist(Student student) {
        entityManager.persist(student);
    }

    public Student findOne(int id) {
        return entityManager.find(Student.class, id);
    }

    public Student update(Student student) {
        return entityManager.merge(student);
    }
}
