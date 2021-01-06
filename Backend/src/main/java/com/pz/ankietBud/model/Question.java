package com.pz.ankietBud.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Discriminator", discriminatorType = DiscriminatorType.STRING)
public abstract class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private ArrayList<Long> votes;
    private Long sum;

    public Question() {
    }

    public Question(Long id, String content, ArrayList<Long> votes, Long sum) {
        this.id = id;
        this.content = content;
        this.votes = votes;
        this.sum = sum;
    }

    public Question(String content, ArrayList<Long> votes, Long sum) {
        this.content = content;
        this.votes = votes;
        this.sum = sum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Long> getVotes() {
        return votes;
    }

    public void setVotes(ArrayList<Long> votes) {
        this.votes = votes;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
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
