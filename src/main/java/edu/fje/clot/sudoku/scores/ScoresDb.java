package edu.fje.clot.sudoku.scores;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import edu.fje.clot.sudoku.scores.db.ScoreDbUtil;

/**
 * Created by m0R on 11/21/16.
 */


public class ScoresDb implements IScores {

    private ScoreDbUtil scoreTable;

    public ScoresDb(Context context){
        scoreTable = new ScoreDbUtil(context);
        if(scoreTable.count() == 0) {
            List<Score> list = new ArrayList<>();
            //De momento nos las inventamos
            GregorianCalendar date = new GregorianCalendar();
            date.set(2016, 10, 20, 12, 30, 0);
            list.add(new Score(1000, date.getTime()));
            date.set(2016, 9, 30, 11, 30, 0);
            list.add(new Score(1500, date.getTime()));
            date.set(2016, 8, 20, 12, 30, 0);
            list.add(new Score(400, date.getTime()));
            date.set(2016, 10, 10, 11, 10, 0);
            list.add(new Score(700, date.getTime()));
            scoreTable.insertAll(list);
        }
    }

    public List<Score> getTop(int n){
        return scoreTable.findTop(n);
    }
    public Score getAnOrdenadeIndexTop(int n){
        return scoreTable.find(n);
    }
    public int NumerodePuntuacions(){

        return scoreTable.count();
    }
    public List<Score> getList() {
        return scoreTable.findAll();
    }

}
