package com.limethecoder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "school_class")
public class SchoolClass {
    @Id
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private TeacherProfile manager;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;


    @OneToMany(mappedBy = "schoolClass", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<StudentProfile> students;
}
