package edu.fje.clot.sudoku;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import edu.fje.clot.sudoku.matrix.Sudoku;

/**
 * Created by oriol on 11/12/16.
 */

public class GameActivity extends Activity implements View.OnClickListener {
    int[][] SudokuSolution;
    int[][] EmptySudoku;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SudokuSolution= Sudoku.getInstance().Load();
        EmptySudoku= Sudoku.getInstance().ClearSudoku(SudokuSolution);
        GameMotor gameMotor = new GameMotor();
        gameMotor.setSudoku(EmptySudoku);
        setContentView(R.layout.activity_game);

    }

    @Override
    public void onClick(View view) {

    }
}
