package com.PZ.AnkietBud.classes.subQuestion;

import com.PZ.AnkietBud.classes.Question;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.ArrayList;

@Entity
@DiscriminatorValue("Scale")
@PrimaryKeyJoinColumn(name = "id")
public class Scale extends Question {
    public Scale(String content, ArrayList<Integer> votes, Integer sum, String anchor_left, String anchor_right, String anchor_central, Integer value_min, Integer value_max) {
        super(content, votes, sum);
        this.anchor_left = anchor_left;
        this.anchor_right = anchor_right;
        this.anchor_central = anchor_central;
        this.value_min = value_min;
        this.value_max = value_max;
    }

    public Scale() {
    }

    private String anchor_left;
    private String anchor_right;

    public String getAnchor_left() {
        return anchor_left;
    }

    public void setAnchor_left(String anchor_left) {
        this.anchor_left = anchor_left;
    }

    public String getAnchor_right() {
        return anchor_right;
    }

    public void setAnchor_right(String anchor_right) {
        this.anchor_right = anchor_right;
    }

    public String getAnchor_central() {
        return anchor_central;
    }

    public void setAnchor_central(String anchor_central) {
        this.anchor_central = anchor_central;
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

    private String anchor_central;

    public Scale(Integer id, String content, ArrayList<Integer> votes, Integer sum, String anchor_left, String anchor_right, String anchor_central, Integer value_min, Integer value_max) {
        super(id, content, votes, sum);
        this.anchor_left = anchor_left;
        this.anchor_right = anchor_right;
        this.anchor_central = anchor_central;
        this.value_min = value_min;
        this.value_max = value_max;
    }

    private Integer value_min;
    private Integer value_max;

    @Override
    public String toString() {
        return "Scale{" +
                "anchor_left='" + anchor_left + '\'' +
                ", anchor_right='" + anchor_right + '\'' +
                ", anchor_central='" + anchor_central + '\'' +
                ", value_min=" + value_min +
                ", value_max=" + value_max +
                '}';
    }
}
