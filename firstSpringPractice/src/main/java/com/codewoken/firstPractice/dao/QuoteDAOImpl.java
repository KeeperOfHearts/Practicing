package com.codewoken.firstPractice.dao;

import com.codewoken.firstPractice.entity.Quote;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuoteDAOImpl implements QuoteDAO{

    private final EntityManager entityManager;

    @Autowired
    public QuoteDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
        public void save(Quote quote) {
        entityManager.persist(quote);
    }

    @Override
    public String getRandom() {
        TypedQuery<Quote> theQuery = entityManager.createQuery("FROM Quote", Quote.class);
        int randomIndex = (int) (Math.random() * theQuery.getResultList().size());
        return theQuery.getResultList().get(randomIndex).getQuote();
    }
}
