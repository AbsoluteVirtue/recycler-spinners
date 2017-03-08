package com.example.spinners.model;

public class QaItem {

    private int id;
    private String question;
    private String[] options;

    public QaItem() {
    }

    public QaItem(int id, String question, String[] options) {
        this.id = id;
        this.question = question;
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
