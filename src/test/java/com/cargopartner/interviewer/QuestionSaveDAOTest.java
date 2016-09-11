package com.cargopartner.interviewer;

import com.cargopartner.interviewer.domain.question.answer.Answer;
import com.cargopartner.interviewer.domain.question.ChoiceQuestion;
import org.junit.Test;

import java.util.Arrays;

public class QuestionSaveDAOTest {


    @Test
    void testQuestionSave() {
        ChoiceQuestion question = new ChoiceQuestion();
        question.setQuestion("Drbe hibernatu?");

        Answer answer1 = new Answer();
        answer1.setAnswer("Tak urciteeee");
        answer1.setCorrect(true);

        Answer answer2 = new Answer();
        answer2.setAnswer("Jedineee");
        answer2.setCorrect(true);

        // em.persist(question);

        question.getAnswers().addAll(Arrays.asList(answer1, answer2));

        assert true;
    }


}
