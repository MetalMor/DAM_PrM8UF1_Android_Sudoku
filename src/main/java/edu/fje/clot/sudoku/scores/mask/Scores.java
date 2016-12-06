package edu.fje.clot.sudoku.scores.mask;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import edu.fje.clot.sudoku.scores.Score;

/**
 * Classe que representa el control de llistes en memoria.
 * LEGACY
 * Created by oriol on 11/8/16.
 */


public class Scores implements IScores {

    /**
     * Llista de puntuacions.
     */
    private List<Score> _list = new ArrayList<>();

    /**
     * Constructor buit. Inicialitza la llista de puntuacions amb 4 puntuacions
     * inicials.
     */
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

    /**
     * Constructor amb context (per compatibilitat amb el codi). No fa res que no faci el buit.
     * @param context Context.
     */
    public Scores(Context context) { this(); }

    /**
     * Retorna els primers n elements, segons l'ordre per quantitat de punts descendent.
     * @param n int
     * @return List<Score>
     */
    public List<Score> getTop(int n){
        Collections.sort(_list);
        return _list.subList(0, n);
    }

    /**
     * Retorna un item a una posicio especificada.
     * @param n int
     * @return Score
     */
    public Score getItem(int n){
        Collections.sort(_list);
        return _list.get(n);
    }

    /**
     * Retorna el recompte d'elements.
     * @return int
     */
    public int count(){
        return _list.size();
    }

    /**
     * Retorna la llista de puntuacions.
     * @return List<Score>
     */
    public List<Score> getList() {
        if(_list == null) _list = new ArrayList<>();
        return _list;
    }

    /**
     * Assigna una llista com a llista de puntuacions.
     * @param list List<Score>
     */
    public void setList(ArrayList<Score> list) {
        this._list = list;
    }
}
