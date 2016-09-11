package com.cargopartner.interviewer.domain.question;

import com.cargopartner.interviewer.domain.AbstractEntity;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "questions", schema = "interviewer")
@DiscriminatorColumn(name = "question_type")
@DiscriminatorOptions(force = true)
abstract public class Question extends AbstractEntity {

    @Column(name = "question")
    @NotNull
    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(final String question) {
        this.question = question;
    }

    abstract <T> T apply(QuestionVisitor<T> visitor);

}
