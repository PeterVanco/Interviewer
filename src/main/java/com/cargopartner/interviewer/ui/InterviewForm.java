package com.cargopartner.interviewer.ui;

import com.cargopartner.interviewer.boundary.QuestionSaveDAO;
import com.cargopartner.interviewer.ui.question.QuestionCreateField;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public class InterviewForm extends VerticalLayout {

    @Inject
    private QuestionSaveDAO questionSaveDAO;
    @Inject
    private Instance<QuestionCreateField> questionFieldInstance;
    private VerticalLayout questions;

    @PostConstruct
    private void init() {

        questions = new VerticalLayout();
        createQuestion();

        Button addQuestionButton = new Button("Add question");
        addQuestionButton.addClickListener(e -> createQuestion());

        Button saveButton = new Button("Save interview");
        saveButton.addClickListener(e -> {
            questions.iterator().forEachRemaining(c -> {
                if (c instanceof QuestionCreateField) {
                    QuestionCreateField questionCreateField = (QuestionCreateField) c;
                    questionSaveDAO.save(questionCreateField.getValue());
                }
            });
        });

        addComponents(questions, addQuestionButton, saveButton);
    }

    private void createQuestion() {
        QuestionCreateField question = questionFieldInstance.get();
        questions.addComponent(question);
    }

}
