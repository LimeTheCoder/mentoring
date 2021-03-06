package com.limethecoder.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_profile")
@Getter
@Setter
public class StudentProfile extends UserProfile {
    @Column(name = "enrollment_year")
    private int enrollmentYear;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;
}
