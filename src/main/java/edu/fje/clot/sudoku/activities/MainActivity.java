package edu.fje.clot.sudoku.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import edu.fje.clot.sudoku.R;
import edu.fje.clot.sudoku.scores.mask.IScores;
import edu.fje.clot.sudoku.scores.ScoreAdapter;
import edu.fje.clot.sudoku.scores.mask.Scores;
import edu.fje.clot.sudoku.scores.mask.ScoresDb;

public class MainActivity extends Activity implements View.OnClickListener {
    IScores Puntuacions;
    private ListView ScoreWins;
    ScoreAdapter adapter;
    int[] imatges = {
            R.drawable.medallaor,
            R.drawable.medallaplata,
            R.drawable.medallabronze,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.play).setOnClickListener(this);

        //Puntuacions = new ScoresDb(getApplicationContext());
        Puntuacions = new Scores();

        adapter = new ScoreAdapter(this, Puntuacions, imatges);
        ((ListView) findViewById(R.id.LlistaPuntuacions)).setAdapter(adapter);

    }
    public void onClick(View arg0) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
