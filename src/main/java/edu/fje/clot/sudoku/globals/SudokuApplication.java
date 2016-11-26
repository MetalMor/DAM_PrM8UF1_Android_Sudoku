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
 * Created by oriol on 11/26/16.
 */

public class SudokuApplication extends Application{
   private static Context context;
    Score Puntuaciopartida;
    View rootview;
    int[] solution;

    public void onCreate(){
        super.onCreate();
        this.context= this;
    }
   public void setPuntuaciopartida(Score Puntuaciopartida){

        this.Puntuaciopartida=Puntuaciopartida;

    }

    public Score getPuntuaciopartida() {
        return Puntuaciopartida;
    }

    public void setSolution(int [] solution) {
        this.solution = solution;
    }
    public int[] getSolution(){
        return solution;
    }
    public void setRootview(View rootview) {
        this.rootview = rootview;
    }
    public View getRootview(){
        return rootview;
    }

    public static Context getContext(){
        return context;
    }
}
