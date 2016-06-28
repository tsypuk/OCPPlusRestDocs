package jav.smart.model;

/**
 * Created by roman.tsypuk on 6/4/16.
 */
public class Answer {
    private Long id;
    private String body;
    private Boolean correct;
    private Long questionId;
    private String letter;

    public Answer(Long id, String body, Boolean isCorrect, Long questionId) {
        this.id = id;
        this.body = body;
        this.correct = isCorrect;
        this.questionId = questionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }




}
