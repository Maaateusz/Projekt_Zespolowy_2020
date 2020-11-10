package com.PZ.AnkietBud.mainClasses;

public class Answer {

    private Integer id;
    private String type;
    private String content;
    private Integer number_of_votes;

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNumber_of_votes() {
        return number_of_votes;
    }

    public void setNumber_of_votes(Integer number_of_votes) {
        this.number_of_votes = number_of_votes;
    }
}
