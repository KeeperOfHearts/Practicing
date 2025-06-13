package com.codewoken.firstPractice.rest;

import com.codewoken.firstPractice.dao.QuoteDAO;
import com.codewoken.firstPractice.service.QuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final QuotesService service;

    @Autowired
    public Controller(QuotesService dao) {
        this.service = dao;
    }


    @Autowired
    public void setCoach() {

    }


    @GetMapping("data")
    public String getData() {
        return "Hello, World!";
    }

    @GetMapping("quoteOfTheDay")
    public String quoteOfTheDay() {
        return service.getRandomQuote();
    }
}
