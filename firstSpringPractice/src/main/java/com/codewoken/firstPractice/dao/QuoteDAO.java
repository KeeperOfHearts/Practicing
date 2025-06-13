package com.codewoken.firstPractice.dao;

import com.codewoken.firstPractice.entity.Quote;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteDAO {

    void save(Quote quote);

    String getRandom();
}
