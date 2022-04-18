package com.audriuskumpis.persistence;

import com.audriuskumpis.entities.Instructor;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class InstructorsDAO {

    @Setter
    @Inject
    private EntityManager entityManager;

    public void persist(Instructor instructor) {
        entityManager.persist(instructor);
    }

    public List<Instructor> findAll() {
        return entityManager.createNamedQuery("Instructor.findAll", Instructor.class).getResultList();
    }

    public Instructor findByName(String name) {
        try {
            Query query = entityManager.createNamedQuery("Instructor.findByName");
            query.setParameter("name", name);
            return (Instructor) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }
}
