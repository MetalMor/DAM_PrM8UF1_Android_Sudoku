package edu.fje.clot.sudoku.scores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by becari on 21/11/2016.
 */

public interface IScores {
    public List<Score> getTop(int n);
    public Score getAnOrdenadeIndexTop(int n);
    public int NumerodePuntuacions();
    public List<Score> getList();
}
