package model;

import java.util.List;

/**
 * Created by roman.tsypuk on 6/4/16.
 */
public class Question {
    private Long id;
    private String text;
    private String description;
    private List<Answer> answers;

    public Question() {
    }

    public Question(Long id, String text, String description) {
        this.id = id;
        this.text = text;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
