package edu.fje.clot.sudoku.scores;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.Date;

import edu.fje.clot.sudoku.scores.db.ScoreDbUtil;

/**
 * Created by oriol on 11/8/16.
 */

public class Score implements Comparable<Score> {
    /**
     * Identificador numeric unic.
     */
    private int _id;
    /**
     * Valor de la puntuacio.
     */
    private int _value;
    /**
     * Data de joc.
     */
    private Date _date=new Date();

    /**
     * Constructor buit.
     */
    public Score() { }

    /**
     * Constructor que assigna un nou identificador a partir del context.
     * @param context Context
     */
    private Score(Context context) {
        setId(getNewId(context));
    }

    /**
     * Constructor que assigna un nou identificador a partir d'un parametre.
     * @param id int
     */
    private Score(int id) {
        this();
        setId(id);
    }

    /**
     * Constructor que asigna identificador, valor i data a partir de parametres.
     * @param id int
     * @param value int
     * @param date Date
     */
    public Score(int id, int value, Date date) {
        this(id);
        setValue(value);
        setDate(date);
    }

    /**
     * Crea i retorna un nou objete Score amb id autogenerada a partir del context.
     * @param context Context
     * @return
     */
    public static Score newScore(Context context) {
        return new Score(context);
    }

    /**
     * Compara els objectes Score a partir del seu valor. Si el propi valor es major que
     * l'evaluat, retorna positiu.
     * @param score Score
     * @return int
     */
    @Override
    public int compareTo(@NonNull Score score) {
       return score.getValue() - getValue();
    }

    /**
     * Retorna el valor de la puntuacio.
     * @return int
     */
    public int getValue() {
        return _value;
    }

    /**
     * Assigna el valor de la puntuacio.
     * @param value int
     */
    public void setValue(int value) {
        this._value = value;
    }

    /**
     * Incrementa el valor de la puntuacio
     * @param increment int
     */
    public void ValueIncrement(int increment){ this._value+=increment;}

    /**
     * Retorna la data de la puntuacio.
     * @return Date
     */
    public Date getDate() {
        return _date;
    }

    /**
     * Asigna la data de la puntuacio.
     * @param date Date
     */
    public void setDate(Date date) {
        this._date = date;
    }

    /**
     * Retorna l'identificador de la puntuacio.
     * @return int
     */
    public int getId() { return _id; }

    /**
     * Assigna l'identificador de la puntuacio.
     * @param id int
     */
    public void setId(int id) { _id = id; }

    /**
     * Retorna un nou identificador a partir del context especificat.
     * @param context Context
     * @return int
     */
    private static int getNewId(Context context) {
        ScoreDbUtil scoreTable = new ScoreDbUtil(context);
        return scoreTable.findMaxId()+1;
    }
}
