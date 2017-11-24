package com.limethecoder.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document
public class Question {
    @NotBlank
    private String text;
    private QuestionType type;
    private int weight;
    @NotEmpty
    private List<String> availableChoices;
    @NotEmpty
    private List<String> correctAnswers;
}
