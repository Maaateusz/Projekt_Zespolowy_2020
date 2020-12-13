package com.pz.ankietBud.model.subQuestion;

import com.pz.ankietBud.model.Question;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@DiscriminatorValue("Rating")
@PrimaryKeyJoinColumn(name = "id")
public class Rating extends Question {

    private Integer value_min;
    private Integer value_max;
    @Enumerated(EnumType.STRING)
    private Type type;

    public Rating(Integer id, String content, ArrayList<Integer> votes, Integer sum, Integer value_min, Integer value_max, Type type) {
        super(id, content, votes, sum);
        this.value_min = value_min;
        this.value_max = value_max;
        this.type = type;
    }

    public Rating() {
    }

    public Rating(String content, ArrayList<Integer> votes, Integer sum, Integer value_min, Integer value_max, Type type) {
        super(content, votes, sum);
        this.value_min = value_min;
        this.value_max = value_max;
        this.type = type;
    }

    public Integer getValue_min() {
        return value_min;
    }

    public void setValue_min(Integer value_min) {
        this.value_min = value_min;
    }

    public Integer getValue_max() {
        return value_max;
    }

    public void setValue_max(Integer value_max) {
        this.value_max = value_max;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "value_min=" + value_min +
                ", value_max=" + value_max +
                ", type=" + type +
                '}';
    }

    public enum Type {
        stars,
        hearts
    }
}
