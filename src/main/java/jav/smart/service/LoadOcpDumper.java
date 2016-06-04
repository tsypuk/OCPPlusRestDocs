package jav.smart.service;

import jav.smart.model.Question;

import java.util.List;

/**
 * Created by roman.tsypuk on 6/4/16.
 */
public interface LoadOcpDumper {
    List<Question> loadQuestions();
    Question loadQuestion(long questionId);
}