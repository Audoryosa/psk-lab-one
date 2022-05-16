package com.audriuskumpis.persistence;

import com.audriuskumpis.entities.Course;
import com.audriuskumpis.entities.Instructor;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class CoursesDAO {

    @Setter
    @Inject
    private EntityManager entityManager;

    public List<Course> loadAll() {
        return entityManager.createNamedQuery("Course.findAll", Course.class).getResultList();
    }

    public void persist(Course course) {
        entityManager.persist(course);
    }

    public Course findOne(int id) {
        return entityManager.find(Course.class, id);
    }

    public void update(Course course) {
        entityManager.merge(course);
    }

    public Course findByName(String courseName) {
        try {
            Query query = entityManager.createNamedQuery("Course.findByName");
            query.setParameter("name", courseName);
            return (Course) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
