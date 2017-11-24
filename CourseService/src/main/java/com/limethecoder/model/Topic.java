package com.limethecoder.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Topic {
    @NotBlank
    private String title;
    private String description;
    private Quiz quiz;
}
