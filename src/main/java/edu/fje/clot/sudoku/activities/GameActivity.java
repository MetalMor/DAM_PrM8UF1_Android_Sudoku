package edu.fje.clot.sudoku.activities;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import edu.fje.clot.sudoku.R;
import edu.fje.clot.sudoku.matrix.Sudoku;

import edu.fje.clot.sudoku.matrix.SudokuAdapter;

/**
 * Created by oriol on 11/12/16.
 */

public class GameActivity extends Activity implements View.OnClickListener {
    int[][] SudokuSolution;
    int[][] EmptySudoku;
    GridView   Grid;
    SudokuAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SudokuSolution = Sudoku.getInstance().Load();
        EmptySudoku = Sudoku.getInstance().ClearSudoku(SudokuSolution, 56);
        int[] matrix = getResources().getIntArray(R.array.matrix);
        setContentView(R.layout.activity_game);

        final int[] OnedimensionSudoku =Sudoku.ConvertoOneDimension(EmptySudoku);
         Grid = (GridView) findViewById(R.id.Graella);
        customAdapter = new SudokuAdapter(getApplicationContext(),OnedimensionSudoku);
        Grid.setAdapter(customAdapter);
    }


    @Override
    public void onClick(View view) {

    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

            outState.putInt("gridView" ,Grid.getId());
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        int viewId = savedInstanceState.getInt("gridView");
        Grid.setId(viewId);
    }
}
