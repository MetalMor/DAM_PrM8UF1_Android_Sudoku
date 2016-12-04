package edu.fje.clot.sudoku.globals;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

/**
 * Created by oriol on 11/26/16.
 */

public class ScoreUpdate extends AsyncTask<String, Void, String> {
    private Context context;
    private View view;
    public ScoreUpdate(Context context,View view){
        this.context=context;
        this.view= view;
    }

    @Override
    protected String doInBackground(String... params) {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.interrupted();
            }
        }
        return "Executed";
    }
}


