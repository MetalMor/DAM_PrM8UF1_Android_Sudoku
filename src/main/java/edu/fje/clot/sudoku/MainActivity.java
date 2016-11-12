package edu.fje.clot.sudoku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.List;

import edu.fje.clot.sudoku.action.LoadGameAction;

public class MainActivity extends AppCompatActivity {

    private Button btnPlay;
    Scores Puntuacions;
    private ListView ScoreWins;
    ScoreAdapter adapter;
    int[] imatges= {
            R.drawable.medallaor,
            R.drawable.medallaplata,
            R.drawable.medallabronze,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPlay = (Button) findViewById(R.id.play);
        btnPlay.setOnClickListener(new LoadGameAction());
        ScoreWins = (ListView) findViewById(R.id.LlistaPuntuacions);
        Puntuacions = new Scores();
        setContentView(R.layout.activity_main);
        final ListView Llista = (ListView) findViewById(R.id.LlistaPuntuacions);
        adapter = new ScoreAdapter(this, Puntuacions, imatges);
        Llista.setAdapter(adapter);

    }
}
