package com.pz.ankietBud.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Discriminator", discriminatorType = DiscriminatorType.STRING)
public abstract class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String content;
    private ArrayList<Integer> votes;
    private Integer sum;

    public Question() {
    }

    public Question(Integer id, String content, ArrayList<Integer> votes, Integer sum) {
        this.id = id;
        this.content = content;
        this.votes = votes;
        this.sum = sum;
    }

    public Question(String content, ArrayList<Integer> votes, Integer sum) {
        this.content = content;
        this.votes = votes;
        this.sum = sum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Integer> getVotes() {
        return votes;
    }

    public void setVotes(ArrayList<Integer> votes) {
        this.votes = votes;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", votes=" + votes +
                ", sum=" + sum +
                '}';
    }
}
