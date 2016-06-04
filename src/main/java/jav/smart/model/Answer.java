package jav.smart.model;

/**
 * Created by roman.tsypuk on 6/4/16.
 */
public class Answer {
    private Long id;
    private String body;
    private Boolean isCorrect;
    private Long questionId;

    public Answer(Long id, String body, Boolean isCorrect, Long questionId) {
        this.id = id;
        this.body = body;
        this.isCorrect = isCorrect;
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
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
