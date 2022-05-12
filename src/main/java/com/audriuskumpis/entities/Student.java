package com.audriuskumpis.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.io.Serializable;

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
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;

    @Column(name = "FULL_NAME")
    String fullName;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    @Column(name = "STUDENT_ID")
    private Integer studentId;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    public Student(String fullName) {
        this.fullName = fullName;
    }

    public Student(String fullName, Course course) {
        this(fullName);
        this.course = course;
    }
}
