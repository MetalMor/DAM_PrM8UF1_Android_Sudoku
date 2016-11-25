package edu.fje.clot.sudoku.scores.mask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.fje.clot.sudoku.scores.Score;

/**
 * Created by becari on 21/11/2016.
 */

public interface IScores {
    public List<Score> getTop(int n);
    public Score getItem(int n);
    public int count();
    public List<Score> getList();
}
