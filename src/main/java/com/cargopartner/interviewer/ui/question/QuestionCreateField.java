package com.cargopartner.interviewer.ui.question;

import com.cargopartner.interviewer.domain.question.Question;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomField;

import javax.inject.Inject;

public class QuestionCreateField extends CustomField<Question> {

    @Inject
    private QuestionCreateForm questionCreateForm;

    @Override
    protected Component initContent() {
        return questionCreateForm;
    }

    @Override
    public Class<? extends Question> getType() {
        return Question.class;
    }

    @Override
    public Question getValue() {
        return questionCreateForm.getValue();
    }
}
