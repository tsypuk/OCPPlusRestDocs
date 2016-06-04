package jav.smart.controllers;

import jav.smart.model.Question;
import jav.smart.service.LoadOcpDumper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by roman.tsypuk on 6/4/16.
 */
@RestController
public class OCPController {

    @Autowired
    private LoadOcpDumper loadOcpDump;

    @RequestMapping(value = "/generate/{id}")
    public Question getQuestionById(@PathVariable("id") int questionId) {
         return loadOcpDump.loadQuestion(questionId);
    }

    @RequestMapping(value = "generateAll")
    public List<Question> getAllQuestions() {
        return loadOcpDump.loadQuestions();
    }
}