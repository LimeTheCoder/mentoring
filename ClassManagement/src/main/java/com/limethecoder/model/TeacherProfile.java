package com.limethecoder.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_profile")
@Getter
@Setter
public class TeacherProfile extends UserProfile {
    private String position;
    private int experience;

    @Enumerated(EnumType.STRING)
    private Subject subject;
}
