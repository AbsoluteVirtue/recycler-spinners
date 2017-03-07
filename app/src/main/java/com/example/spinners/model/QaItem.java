package com.example.spinners.model;

public class QaItem {

    private int sortPosition;
    private String question;
    private String[] options;

    public QaItem() {
    }

    public QaItem(int sortPosition, String question, String[] options) {
        this.sortPosition = sortPosition;
        this.question = question;
        this.options = options;
    }

    public int getSortPosition() {
        return sortPosition;
    }

    public void setSortPosition(int sortPosition) {
        this.sortPosition = sortPosition;
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

    @Override
    public String toString() {
        return "QaItem{" +
                "question='" + question + '\'' +
                '}';
    }
}
