package edu.fje.clot.sudoku.globals;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import edu.fje.clot.sudoku.R;
import edu.fje.clot.sudoku.scores.Score;

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

        @Override
        protected void onPostExecute(String result) {
          /*  Application application = (Application)SudokuApplication.getContext();
            SudokuApplication app = (SudokuApplication)application;

        TextView textView  = (TextView) view.findViewById(R.id.TxtVScore);
            textView.setText(Integer.toString(app.getPuntuaciopartida().getValue()));
            Log.v("ScoreUpdate",Integer.toString(app.getPuntuaciopartida().getValue()));

            */
            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }


