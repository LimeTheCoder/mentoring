package com.limethecoder.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Document(collection = "Course")
public class Course {
    @Id
    private String id;
    @Indexed(unique = true)
    @NotBlank
    private String name;
    private LocalDateTime creationDate;
    @NotEmpty
    private List<String> teachers;
    private List<Topic> topics;
}
