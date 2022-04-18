package com.audriuskumpis.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "COURSE")
@NamedQueries({
        @NamedQuery(name = "Course.findAll", query = "select a from Course as a")
})
public class Course {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;

    @Size(max = 50)
    @Column(name = "TITLE")
    String title;

    @OneToMany(mappedBy = "course")
    List<Student> students = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    List<Instructor> instructors;

    public Course(String title) {
        this.title = title;
    }

    public Course(String title, List<Student> students) {
        this(title);
        this.students = students;
    }

}