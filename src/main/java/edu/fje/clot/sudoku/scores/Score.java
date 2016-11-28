package edu.fje.clot.sudoku.scores;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.Date;

import edu.fje.clot.sudoku.scores.db.ScoreDbUtil;

/**
 * Created by oriol on 11/8/16.
 */

public class Score implements Comparable<Score> {

    private int _id;
    private int _value;
    private Date _date=new Date();
    public Score() { }
    private Score(Context context) {
        setId(getNewId(context));
    }
    private Score(int id) {
        this();
        setId(id);
    }
    public Score(int id, int value, Date date) {
        this(id);
        setValue(value);
        setDate(date);
    }

    public static Score newScore(Context context) {
        return new Score(context);
    }

    @Override
    public int compareTo(@NonNull Score score) {
       return score.getValue() - getValue();
    }

    public int getValue() {
        return _value;
    }

    public void setValue(int value) {
        this._value = value;
    }

    public void ValueIncrement(int increment){ this._value+=increment;}

    public Date getDate() {
        return _date;
    }

    public void setDate(Date date) {
        this._date = date;
    }

    public int getId() { return _id; }

    public void setId(int id) { _id = id; }

    private static int getNewId(Context context) {
        ScoreDbUtil scoreTable = new ScoreDbUtil(context);
        return scoreTable.findMaxId()+1;
    }
}
