package com.codewoken.firstPractice.service;

import com.codewoken.firstPractice.dao.QuoteDAO;
import com.codewoken.firstPractice.entity.Quote;
import org.springframework.stereotype.Service;

@Service
public class QuotesService {

    private final QuoteDAO dao;

    public QuotesService(QuoteDAO productRepository) {
        this.dao = productRepository;
    }

    public String getRandomQuote() {
        return dao.getRandom();
    }

}
