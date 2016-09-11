package com.cargopartner.interviewer.boundary;

import com.cargopartner.interviewer.domain.question.Question;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class QuestionSaveDAO {

    @PersistenceContext
    private EntityManager em;

    public <T extends Question> T save(final T question) {
        em.persist(question);
        return question;
    }

}
