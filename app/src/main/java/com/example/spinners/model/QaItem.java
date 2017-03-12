package com.example.spinners.model;

import com.google.gson.annotations.Expose;

public class QaItem {

    @Expose
    private int id;
    @Expose
    private String question;
    @Expose
    private String[] options;

    public QaItem(String question, String[] options) {
        this.question = question;
        this.options = options;
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
