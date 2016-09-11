package com.cargopartner.interviewer.domain.question;

import com.cargopartner.interviewer.domain.question.answer.Answer;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("CHOICE")
public class ChoiceQuestion extends Question {

    @OneToMany(mappedBy = "question",fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @NotNull
    @Size(min = 2)
    private Set<Answer> answers;

    public ChoiceQuestion() {
        answers = new HashSet<>();
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(final Set<Answer> answers) {
        this.answers = answers;
    }

    @Override
    <T> T apply(final QuestionVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
