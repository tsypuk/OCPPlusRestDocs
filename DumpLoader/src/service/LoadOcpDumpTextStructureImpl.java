package service;


import model.Answer;
import model.Question;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadOcpDumpTextStructureImpl implements LoadOcpDumper {
    private String fullPathToDump;

    List<Question> questionDump = new ArrayList<>();

    @Override
    public void init(String pathToDump) throws IOException {
        this.fullPathToDump = pathToDump;
        loadDump();
    }

    @Override
    public List<Question> loadQuestions() {
        return questionDump;
    }

    @Override
    public Question loadQuestion(long questionId) {
        return questionDump.get((int) questionId);
    }

    private void loadDump() throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(new File(fullPathToDump)))) {
            String line;
            Question currentQuestion = null;
            List<Answer> answers = new ArrayList<>();
            long questionId = 0;
            long answerId = 0;
            StringBuilder questionBody = new StringBuilder();
            while ((line = br.readLine()) != null) {
                System.out.println(line);

                switch (line.substring(0, 2)) {
                    case "Q:":
                        currentQuestion = new Question();
                        currentQuestion.setId(++questionId);
                        questionBody.append(line.substring(2) + " \n " );
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
                        answers.add(new Answer(++answerId, line.substring(3), (line.substring(2,3).contains("-"))? false : true, questionId));
                        break;
                    case "E:":
                        currentQuestion.setDescription(line.substring(2));
                        if (!answers.isEmpty()) {
                            currentQuestion.setAnswers(answers);
                            currentQuestion.setText(questionBody.toString());
                            questionDump.add(currentQuestion);
                            questionBody = new StringBuilder();
                            answers = new ArrayList<>();
                        }

                        break;
                    default:
                        questionBody.append(line + " \n ");
                }
            }
        }

        }
    }