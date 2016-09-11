package com.cargopartner.interviewer.domain.question;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("OPEN")
public class OpenQuestion extends Question {

    @Override
    <T> T apply(QuestionVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
