package com.cargopartner.interviewer.domain.question;

public interface QuestionVisitor<T> {

    T visit(OpenQuestion question);

    T visit(ChoiceQuestion question);

}
