package edu.fje.clot.sudoku.scores;

import java.util.Date;

/**
 * Created by oriol on 11/8/16.
 */

public class Score implements Comparable<Score> {

    private int value;
    private Date date=new Date();

    public Score(int value, Date date){
        this.value = value;
        this.date = date;
    }

    @Override
    public int compareTo(Score score) {
       return score.value - this.value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}