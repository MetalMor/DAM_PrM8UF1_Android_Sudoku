package edu.fje.clot.sudoku;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import edu.fje.clot.sudoku.matrix.Sudoku;

import edu.fje.clot.sudoku.matrix.SudokuAdapter;

/**
 * Created by oriol on 11/12/16.
 */

public class GameActivity extends Activity implements View.OnClickListener {
    int[][] SudokuSolution;
    int[][] EmptySudoku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SudokuSolution = Sudoku.getInstance().Load();
        EmptySudoku = Sudoku.getInstance().ClearSudoku(SudokuSolution, 80);

        setContentView(R.layout.activity_game);

        final int[] OnedimensionSudoku =Sudoku.ConvertoOneDimension(EmptySudoku);
        GridView   Grid = (GridView) findViewById(R.id.Graella);
        SudokuAdapter customAdapter = new SudokuAdapter(getApplicationContext(),OnedimensionSudoku);
        Grid.setAdapter(customAdapter);
        Grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int Slecteditem=OnedimensionSudoku[position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
            }
        });
/*
*/
    }

    @Override
    public void onClick(View view) {

    }
}
