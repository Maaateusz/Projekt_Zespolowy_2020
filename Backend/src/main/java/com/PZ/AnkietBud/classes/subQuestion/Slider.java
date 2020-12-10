package com.PZ.AnkietBud.classes.subQuestion;

import com.PZ.AnkietBud.classes.Question;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.ArrayList;

@Entity
@DiscriminatorValue("Slider")
@PrimaryKeyJoinColumn(name = "id")
public class Slider extends Question {
    public Slider(String content, ArrayList<Integer> votes, Integer sum, Integer value_min, Integer value_max, Integer interval) {
        super(content, votes, sum);
        this.value_min = value_min;
        this.value_max = value_max;
        this.interval = interval;
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

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Slider(Integer id, String content, ArrayList<Integer> votes, Integer sum, Integer value_min, Integer value_max, Integer interval) {
        super(id, content, votes, sum);
        this.value_min = value_min;
        this.value_max = value_max;
        this.interval = interval;
    }

    private Integer value_min;
    private Integer value_max;
    private Integer interval;
}
