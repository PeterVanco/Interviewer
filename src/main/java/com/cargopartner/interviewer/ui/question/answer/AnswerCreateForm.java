package com.cargopartner.interviewer.ui.question.answer;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

import javax.annotation.PostConstruct;
import java.util.function.Consumer;

public class AnswerCreateForm extends HorizontalLayout {

    private TextField answerText;

    @PostConstruct
    private void init() {
        answerText = new TextField("Answer: ");
        answerText.setRequired(true);
        addComponent(answerText);
    }

    public void setRemovable(Consumer<AnswerCreateForm> answerFormConsumer) {
        Button removeButton = new Button("Remove answer");
        removeButton.addClickListener(e -> {
            // answerFormConsumer.accept(this);
            throw new RuntimeException();
        });
        addComponent(removeButton);
    }

    public String getValue() {
        return answerText.getValue();
    }
}
