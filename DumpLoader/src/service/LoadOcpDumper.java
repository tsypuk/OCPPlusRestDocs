package service;


import model.Question;

import java.io.IOException;
import java.util.List;

/**
 * Created by roman.tsypuk on 6/4/16.
 */
public interface LoadOcpDumper {
    void init(String pathToDump) throws IOException;
    List<Question> loadQuestions();
    Question loadQuestion(long questionId);
}