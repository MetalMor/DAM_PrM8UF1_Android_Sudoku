package edu.fje.clot.sudoku.scores.mask;

import android.content.Context;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import edu.fje.clot.sudoku.scores.Score;
import edu.fje.clot.sudoku.scores.db.ScoreDbUtil;

/**
 * Created by m0R on 11/21/16.
 */


public class ScoresDb implements IScores {

    private ScoreDbUtil _table;
    private List<Score> _list;

    public ScoresDb(Context context){
        setTable(new ScoreDbUtil(context));
        if(count() <= 0) {
            List<Score> list = new ArrayList<>();
            //De momento nos las inventamos
            GregorianCalendar date = new GregorianCalendar();
            date.set(2016, 10, 20, 12, 30, 0);
            list.add(new Score(0, 1000, date.getTime()));
            date.set(2016,9,30,11,30,0);
            list.add(new Score(1, 1500, date.getTime()));
            date.set(2016,8,20,12,30,0);
            list.add(new Score(2, 400, date.getTime()));
            date.set(2016,10,10,11,10,0);
            list.add(new Score(3, 700, date.getTime()));
            getTable().insertAll(list);
        }
    }

    public List<Score> getTop(int n){
        return getTable().findTop(n);
    }
    public Score getItem(int n){
        return getList().get(n);
    }
    public int count() {
        return getTable().count();
    }
    public List<Score> getList() {
        boolean updateRequired = _list == null ||
                        _list.isEmpty() ||
                        getTable().count() != _list.size();
        if (updateRequired) setList(getTable().findAll());
        return _list;
    }
    public void setList(List<Score> list) { _list = list; }

    public ScoreDbUtil getTable() { return _table; }
    private void setTable(ScoreDbUtil table) { _table = table; }


}
