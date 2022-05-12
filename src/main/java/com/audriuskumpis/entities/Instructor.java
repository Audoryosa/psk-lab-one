package com.audriuskumpis.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "INSTRUCTOR")
@NamedQueries({
        @NamedQuery(name = "Instructor.findAll", query = "select a from Instructor as a"),
        @NamedQuery(name = "Instructor.findByName", query = "select a from Instructor as a where lower(a.name) = lower(:name)")
})
@EqualsAndHashCode
public class Instructor implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;

    @Column(name = "NAME")
    String name;

    @Column
    @ManyToMany
    @JoinTable(
            name = "INSTRUCTED_COURSE",
            joinColumns = @JoinColumn(name = "INSTRUCTOR_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID")
    )
    List<Course> courses;


    public Instructor(String name) {
        this.name = name;
    }
}
