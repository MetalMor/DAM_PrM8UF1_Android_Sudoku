package edu.fje.clot.sudoku.scores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by oriol on 11/8/16.
 */


public class Scores {

    private ArrayList<Score> list= new ArrayList<Score>();

    public Scores(){
        //De momento nos las inventamos
        GregorianCalendar date = new GregorianCalendar();
        date.set(2016,10,20,12,30,0);
        list.add(new Score(1000, date.getTime()));
        date.set(2016,9,30,11,30,0);
        list.add(new Score(1500, date.getTime()));
        date.set(2016,8,20,12,30,0);
        list.add(new Score(400, date.getTime()));
        date.set(2016,10,10,11,10,0);
        list.add(new Score(700, date.getTime()));
    }

    public List<Score> getTop(int n){
        Collections.sort(list);
        return list.subList(0, n);
    }
    public Score getAnOrdenadeIndexTop(int n){
        Collections.sort(list);
        return list.get(n);
    }
    public int NumerodePuntuacions(){

        return list.size();
    }
    public ArrayList<Score> getList() {
        return list;
    }

    public void setList(ArrayList<Score> list) {
        this.list = list;
    }
}
