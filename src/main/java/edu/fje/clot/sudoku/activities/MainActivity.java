package edu.fje.clot.sudoku.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import edu.fje.clot.sudoku.R;
import edu.fje.clot.sudoku.scores.mask.IScores;
import edu.fje.clot.sudoku.scores.ScoreAdapter;
import edu.fje.clot.sudoku.scores.mask.ScoresDb;

public class MainActivity extends Activity implements View.OnClickListener {
    IScores Puntuacions;
    ScoreAdapter adapter;
    ImageView helpimg;
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

        Puntuacions = new ScoresDb(getApplicationContext());
        //Puntuacions = new Scores();

        adapter = new ScoreAdapter(this, Puntuacions, imatges);
        ((ListView) findViewById(R.id.LlistaPuntuacions)).setAdapter(adapter);
        helpimg = (ImageView) findViewById(R.id.imageView2);
        helpimg.setImageResource(R.drawable.help);
        findViewById(R.id.imageView2).setOnClickListener(this);



    }
    public void onClick(View arg0) {
        switch(arg0.getId()){

            case R.id.play: /** Start a new Activity MyCards.java */
                Intent intent = new Intent(this, GameActivity.class);
                startActivity(intent);
                break;

            case R.id.imageView2 :/** AlerDialog when click on Exit */
                Intent intent2 = new Intent(this, HelpActivity.class);
                startActivity(intent2);
                break;
        }

    }
}
