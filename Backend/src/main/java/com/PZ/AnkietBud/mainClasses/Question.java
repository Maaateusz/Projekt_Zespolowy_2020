package com.PZ.AnkietBud.mainClasses;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name="Discriminator", discriminatorType= DiscriminatorType.STRING)
public abstract class Question {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String content;
    private ArrayList<Integer> votes;
    private Integer sum;

}
