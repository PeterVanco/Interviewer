package com.cargopartner.interviewer.boundary;

import com.cargopartner.interviewer.domain.question.Question;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class QuestionGetDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Question> getQuestions() {

        // return em.createQuery("select q from Question q").getResultList();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Question> query = cb.createQuery(Question.class);

        Root<Question> root = query.from(Question.class);
        // root.fetch(root.get("answers"), JoinType.LEFT);

        query.select(root);

        return em.createQuery(query).getResultList();
    }

}
