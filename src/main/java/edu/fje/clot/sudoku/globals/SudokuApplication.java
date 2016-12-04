package edu.fje.clot.sudoku.globals;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import edu.fje.clot.sudoku.R;
import edu.fje.clot.sudoku.activities.GameActivity;
import edu.fje.clot.sudoku.scores.Score;

/**
 * Classe que serveix de context global per a l'aplicacio
 * Created by oriol on 11/26/16.
 */

public class SudokuApplication extends Application {
    private static Context context;
    Score Puntuaciopartida;
    View rootview;
    int[] solution;

    /**
     * Inicialitza el component.
     */
    public void onCreate(){
        super.onCreate();
        context= this;
    }

    /**
     * Assigna un objecte de puntuacio de partida.
     * @param Puntuaciopartida Score
     */
    public void setPuntuaciopartida(Score Puntuaciopartida) {
        this.Puntuaciopartida=Puntuaciopartida;
    }

    /**
     * Retorna l'objecte de puntuacio de partida
     * @return Score
     */
    public Score getPuntuaciopartida() {
        return Puntuaciopartida;
    }

    /**
     * Assigna un objecte de solucio del sudoku.
     * @param solution int[]
     */
    public void setSolution(int[] solution) {
        this.solution = solution;
    }

    /**
     * Retorna l'objecte de solucio del sudoku.
     * @return int[]
     */
    public int[] getSolution(){
        return solution;
    }

    /**
     * Assigna un objecte de vista arrel.
     * @param rootview View
     */
    public void setRootview(View rootview) {
        this.rootview = rootview;
    }

    /**
     * Retorna l'objecte de vista arrel.
     * @return View
     */
    public View getRootview(){
        return rootview;
    }

    /**
     * Retorna l'objecte de context.
     * @return Context
     */
    public static Context getContext(){
        return context;
    }
}
