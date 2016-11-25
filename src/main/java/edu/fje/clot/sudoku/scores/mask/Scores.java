package edu.fje.clot.sudoku.scores.mask;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import edu.fje.clot.sudoku.scores.Score;

/**
 * Created by oriol on 11/8/16.
 */


public class Scores implements IScores {

    private List<Score> _list = new ArrayList<>();

    public Scores(){
        //De momento nos las inventamos
        GregorianCalendar date = new GregorianCalendar();
        date.set(2016,10,20,12,30,0);
        getList().add(new Score(0, 1000, date.getTime()));
        date.set(2016,9,30,11,30,0);
        getList().add(new Score(1, 1500, date.getTime()));
        date.set(2016,8,20,12,30,0);
        getList().add(new Score(2, 400, date.getTime()));
        date.set(2016,10,10,11,10,0);
        getList().add(new Score(3, 700, date.getTime()));
    }
    public Scores(Context context) { this(); }

    public List<Score> getTop(int n){
        Collections.sort(_list);
        return _list.subList(0, n);
    }
    public Score getItem(int n){
        Collections.sort(_list);
        return _list.get(n);
    }
    public int count(){
        return _list.size();
    }
    public List<Score> getList() {
        if(_list == null) _list = new ArrayList<>();
        return _list;
    }

    public void setList(ArrayList<Score> list) {
        this._list = list;
    }
}
