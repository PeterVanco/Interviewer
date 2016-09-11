package com.cargopartner.interviewer.domain.question.answer;


import com.cargopartner.interviewer.domain.AbstractEntity;
import com.cargopartner.interviewer.domain.question.Question;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "answers", schema = "interviewer")
public class Answer extends AbstractEntity {

    @Column(name = "answer")
    @NotNull
    private String answer;

    @Column(name = "correct", nullable = false)
    @NotNull
    private Boolean correct;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;

    public Answer() {
        super();
        this.correct = false;
    }

    public Answer(final String answer) {
        this();
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(final String answer) {
        this.answer = answer;
    }

    public Boolean isCorrect() {
        return correct;
    }

    public void setCorrect(final Boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(final Question question) {
        this.question = question;
    }
}
