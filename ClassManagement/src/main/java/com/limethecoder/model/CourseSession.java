package com.limethecoder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "course_session")
@Getter
@Setter
public class CourseSession {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";

    @Id
    @JsonIgnore
    private int id;

    @Column(name = "course_key")
    @NotBlank
    private String courseKey;

    @Column(name = "class_id")
    private long schoolClassId;

    @Column(name = "opening_date")
    @JsonFormat(pattern = DATE_FORMAT)
    @NotNull
    private Date openingDate;

    @Column(name = "closing_date")
    @JsonFormat(pattern = DATE_FORMAT)
    @NotNull
    private Date closingDate;
}
