package com.example.spinners.model;

public class QaItem {

    private String question;
    private String[] options;

    public QaItem() {
    }

    public QaItem(String question, String[] options) {
        this.question = question;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

}
