package edu.fje.clot.sudoku.scores.mask;

import java.util.List;

import edu.fje.clot.sudoku.scores.Score;

/**
 * Interface que enmascara les operacions de llistat de puntuacions.
 * Permet utilitzar per igual llistes en memoria i llistes persistents.
 * Created by becari on 21/11/2016.
 */

public interface IScores {
    public List<Score> getTop(int n);
    public Score getItem(int n);
    public int count();
    public List<Score> getList();
}
