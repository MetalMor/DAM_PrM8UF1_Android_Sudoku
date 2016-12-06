package edu.fje.clot.sudoku.scores.mask;

import android.content.Context;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import edu.fje.clot.sudoku.scores.Score;
import edu.fje.clot.sudoku.scores.db.ScoreDbUtil;

/**
 * Control de llistes de puntuacions persistents.
 * Created by m0R on 11/21/16.
 */


public class ScoresDb implements IScores {

    /**
     * Objecte taula de dades.
     */
    private ScoreDbUtil _table;
    /**
     * Llista de puntuacions en memoria.
     */
    private List<Score> _list;

    /**
     * Constructor amb parametre context per assignar l'objecte de taula de dades.
     * @param context
     */
    public ScoresDb(Context context){
        setTable(new ScoreDbUtil(context));

    }

    /**
     * Retorna els primers n elements de la taula de puntuacions, segons l'ordre
     * descendent de puntuacions.
     * @param n int
     * @return List<Score>
     */
    public List<Score> getTop(int n){
        return getTable().findTop(n);
    }

    /**
     * Retorna un objecte a la posicio n de la taula ordenada per valors descendents.
     * @param n int
     * @return Score
     */
    public Score getItem(int n){
        return getList().get(n);
    }

    /**
     * Retorna el recompte de puntuacions de la taula.
     * @return int
     */
    public int count() {
        return getTable().count();
    }

    /**
     * Retorna la llista persistida d'elements. La taula sera refrescada cada vegada que no
     * coincideixi el seu tamany en memoria amb el de la base de dades.
     * @return List<Score>
     */
    public List<Score> getList() {
        boolean updateRequired = _list == null ||
                        _list.isEmpty() ||
                        getTable().count() != _list.size();
        if (updateRequired) setList(getTable().findAll());
        return _list;
    }

    /**
     * Assigna un valor com a llista persistida en memoria.
     * @param list List<Score>
     */
    public void setList(List<Score> list) { _list = list; }

    /**
     * Retorna l'objecte de taula de dades.
     * @return ScoreDbUtil
     */
    public ScoreDbUtil getTable() { return _table; }

    /**
     * Assigna l'objecte de taula de dades.
     * @param table ScoreDbUtil
     */
    private void setTable(ScoreDbUtil table) { _table = table; }


}
