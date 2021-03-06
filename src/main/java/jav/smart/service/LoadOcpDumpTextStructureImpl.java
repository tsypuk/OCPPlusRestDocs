package jav.smart.service;

import jav.smart.model.Answer;
import jav.smart.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoadOcpDumpTextStructureImpl implements LoadOcpDumper {

    @Autowired
    private ResourceLoader resourceLoader;


    List<Question> questionDump = new ArrayList<>();

    @Override
    public List<Question> loadQuestions() {
        return questionDump;
    }

    @Override
    public Question loadQuestion(long questionId) {

        Question question = questionDump.get((int) questionId);
        List<Answer> answers = question.getAnswers();
        for (int i = 0; i < answers.size(); i++) {
            answers.get(i).setLetter(String.valueOf(new Character((char) (65 + i))));
        }
        return question;
    }

    @PostConstruct
    private void loadDump() throws IOException {

        Resource resource = resourceLoader.getResource("classpath:ocp8.dump");
        String fileName = resource.getFile().getAbsoluteFile().toString();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
            String line;
            Question currentQuestion = new Question();
            List<Answer> answers = new ArrayList<>();
            long questionId = 0;
            long answerId = 0;
            StringBuilder questionBody = new StringBuilder();
            StringBuilder descriptionBody = new StringBuilder();
            CurrentElement currentElement = CurrentElement.QUESTION;
            while ((line = br.readLine()) != null) {
                switch (line.substring(0, 2)) {
                    case "--":
                        currentQuestion = new Question();
                        // This is a comment line
                        break;
                    case "Q:":
                        currentQuestion.setDescription(descriptionBody.toString());
                        questionBody = new StringBuilder();
                        answers = new ArrayList<>();
                        currentElement = CurrentElement.QUESTION;
                        currentQuestion = new Question();
                        currentQuestion.setId(++questionId);
                        questionBody.append(line.substring(2) + " \n ");
                        break;
                    case "A.":
                        answers = new ArrayList<>();
                    case "B.":
                    case "C.":
                    case "D.":
                    case "E.":
                    case "F.":
                    case "G.":
                    case "H.":
                        currentElement = CurrentElement.ANSWER;
                        answers.add(new Answer(++answerId, line.substring(3), (line.substring(2, 3).contains("-")) ? false : true, questionId));
                        break;
                    case "Y:":
                        currentElement = CurrentElement.DESRIPTION;
                        currentQuestion.setDescription(line.substring(2));
                        if (!answers.isEmpty()) {
                            currentQuestion.setAnswers(answers);
                            currentQuestion.setText(questionBody.toString());
                            questionDump.add(currentQuestion);

                        }
                        break;
                    default:
                        if (currentElement == CurrentElement.QUESTION) {
                            questionBody.append(line + " \n ");
                        } else if (currentElement == CurrentElement.DESRIPTION) {
                            descriptionBody.append(line);
                        }
                        break;
                }
            }
        }

    }
}

enum CurrentElement {
    DESRIPTION,
    QUESTION,
    ANSWER
}