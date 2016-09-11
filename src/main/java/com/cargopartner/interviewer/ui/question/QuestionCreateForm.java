package com.cargopartner.interviewer.ui.question;

import com.cargopartner.interviewer.domain.question.ChoiceQuestion;
import com.cargopartner.interviewer.domain.question.OpenQuestion;
import com.cargopartner.interviewer.domain.question.Question;
import com.cargopartner.interviewer.domain.question.QuestionType;
import com.cargopartner.interviewer.domain.question.answer.Answer;
import com.cargopartner.interviewer.ui.question.answer.AnswerCreateForm;
import com.vaadin.ui.Button;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.EnumSet;

public class QuestionCreateForm extends VerticalLayout {

    private TextField questionText;
    private OptionGroup questionType;
    private VerticalLayout answers;
    @Inject
    private Instance<AnswerCreateForm> answerFormInstance;

    @PostConstruct
    private void init() {

        questionType = new OptionGroup("Question type:", EnumSet.allOf(QuestionType.class));
        questionType.setMultiSelect(false);
        questionType.select(QuestionType.CHOICE);

        questionText = new TextField("Question:");

        answers = new VerticalLayout();
        createAnswer(false);
        createAnswer(false);

        questionType.addValueChangeListener(e -> answers.setVisible(isChoiceTypeSelected()));

        Button addAnswerButton = new Button("Add answer");
        addAnswerButton.addClickListener(e -> createAnswer(true));

        addComponents(questionType, questionText, answers, addAnswerButton);
    }

    private AnswerCreateForm createAnswer(boolean removable) {
        AnswerCreateForm answerCreateForm = answerFormInstance.get();
        if (removable) {
            answerCreateForm.setRemovable(answers::removeComponent);
        }
        answers.addComponent(answerCreateForm);
        return answerCreateForm;
    }

    private boolean isChoiceTypeSelected() {
        return EnumSet.of(QuestionType.CHOICE).contains(questionType.getValue());
    }

    public Question getValue() {

        if (isChoiceTypeSelected()) {
            ChoiceQuestion question = new ChoiceQuestion();
            setCommonFields(question);

            answers.iterator().forEachRemaining(c -> {
                if (c instanceof AnswerCreateForm) {
                    AnswerCreateForm answerCreateForm = (AnswerCreateForm) c;
                    question.getAnswers().add(new Answer(answerCreateForm.getValue()));
                }
            });

            return question;
        } else {
            OpenQuestion question = new OpenQuestion();
            setCommonFields(question);
            return question;
        }
    }

    private void setCommonFields(final Question question) {
        question.setQuestion(questionText.getValue());
    }

}
