package com.pz.ankietBud.model.subQuestion;

import com.pz.ankietBud.model.Question;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@DiscriminatorValue("Choice")
@PrimaryKeyJoinColumn(name = "id")
public class Choice extends Question {
    private ArrayList<String> answers;
    @Enumerated(EnumType.STRING)
    private Type type;
    public Choice(ArrayList<String> answers, Type type) {
        this.answers = answers;
        this.type = type;
    }

    public Choice() {
    }

    public Choice(String content, ArrayList<Integer> votes, Integer sum, ArrayList<String> answers, Type type) {
        super(content, votes, sum);
        this.answers = answers;
        this.type = type;
    }

    public Choice(Integer id, String content, ArrayList<Integer> votes, Integer sum, ArrayList<String> answers, Type type) {
        super(id, content, votes, sum);
        this.answers = answers;
        this.type = type;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "answers=" + answers +
                ", type=" + type +
                '}';
    }

    public enum Type {
        multiple,
        single
    }
}

