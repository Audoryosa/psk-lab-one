package com.audriuskumpis.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "STUDENT")
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "select a from Student as a")
})
public class Student {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;

    @Column(name = "FULL_NAME")
    String fullName;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    public Student(String fullName) {
        this.fullName = fullName;
    }

    public Student(String fullName, Course course) {
        this(fullName);
        this.course = course;
    }
}
