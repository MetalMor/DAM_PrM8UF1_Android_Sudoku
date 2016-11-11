package edu.fje.clot.sudoku.action;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import edu.fje.clot.sudoku.R;

/**
 * Created by m0r on 11/11/16.
 */

public class LoadGameAction extends AppCompatActivity implements OnClickListener {
    @Override
    public void onClick(View view) {
        setContentView(R.layout.activity_game);
    }
}
