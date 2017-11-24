package com.limethecoder.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document
public class Quiz {
    private int weight;
    @NotBlank
    private List<Question> questions;
}
