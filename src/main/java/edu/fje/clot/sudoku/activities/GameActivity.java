package edu.fje.clot.sudoku.activities;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Random;

import edu.fje.clot.sudoku.R;
import edu.fje.clot.sudoku.globals.ScoreUpdate;
import edu.fje.clot.sudoku.globals.SudokuApplication;
import edu.fje.clot.sudoku.matrix.Sudoku;

import edu.fje.clot.sudoku.matrix.SudokuAdapter;
import edu.fje.clot.sudoku.scores.Score;
import edu.fje.clot.sudoku.scores.db.ScoreDbUtil;
import edu.fje.clot.sudoku.scores.mask.ScoresDb;

import static android.R.id.list;

/**
 * Created by oriol on 11/12/16.
 */

public class GameActivity extends Activity implements View.OnClickListener {
    int[][] SudokuSolution;
    int[][] EmptySudoku;


    private int[] possibleSudokuId = { R.array.matrix_1, R.array.matrix_2, R.array.matrix_3 };
    GridView Grid;
    SudokuAdapter customAdapter;
    TextView textView ;
    SudokuApplication GlobalVar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        int[] SudokuSolutionOnedimension= randomSudoku();
        SudokuSolution = Sudoku.ConvertoTwoDimension(SudokuSolutionOnedimension);
        EmptySudoku = Sudoku.getInstance().ClearSudoku(SudokuSolution, 50);
        setContentView(R.layout.activity_game);
        textView=  (TextView) findViewById(R.id.TxtVScore);
        GlobalVar = (SudokuApplication) getApplicationContext();
        GlobalVar.setPuntuaciopartida(Score.newScore(getApplicationContext()));
        GlobalVar.setSolution(SudokuSolutionOnedimension);
        GlobalVar.setRootview(findViewById(android.R.id.content));

        final int[] OnedimensionSudoku =Sudoku.ConvertoOneDimension(EmptySudoku);
        Grid = (GridView) findViewById(R.id.Graella);
        customAdapter = new SudokuAdapter(getApplicationContext(),OnedimensionSudoku );
        Grid.setAdapter(customAdapter);


        new ScoreUpdate(this, this.findViewById(R.id.activity_game)).execute();


       // GlobalVar.getPuntuaciopartida();

    }

    private int[] randomSudoku() {
       Random rand = new Random();
        return getResources().getIntArray(
                possibleSudokuId[(rand.nextInt(possibleSudokuId.length))
                        ]);}




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

    public void onDestroy() {
        ScoreDbUtil Dbutils = new ScoreDbUtil(this);
        Dbutils.insert(GlobalVar.getPuntuaciopartida());

        //
        super.onDestroy();

    }
}
