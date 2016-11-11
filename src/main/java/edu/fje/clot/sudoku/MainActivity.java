package edu.fje.clot.sudoku;

import android.support.v4.content.ContentResolverCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.fje.clot.sudoku.action.LoadGameAction;

public class MainActivity extends AppCompatActivity {

    private Button btnPlay;

    public MainActivity() {
        btnPlay = (Button) findViewById(R.id.play);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_game);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }
}
