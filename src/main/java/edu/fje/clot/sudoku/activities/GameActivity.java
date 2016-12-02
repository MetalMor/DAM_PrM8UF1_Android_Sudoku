package edu.fje.clot.sudoku.activities;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
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


    private int[] possibleSudokuId = {R.array.matrix_1, R.array.matrix_2, R.array.matrix_3};
    GridView Grid;
    SudokuAdapter customAdapter;
    TextView textView;
    SudokuApplication GlobalVar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        int[] SudokuSolutionOnedimension = randomSudoku();
        SudokuSolution = Sudoku.ConvertoTwoDimension(SudokuSolutionOnedimension);
        EmptySudoku = Sudoku.getInstance().ClearSudoku(SudokuSolution, 50);
        setContentView(R.layout.activity_game);
        textView = (TextView) findViewById(R.id.TxtVScore);
        GlobalVar = (SudokuApplication) getApplicationContext();
        GlobalVar.setPuntuaciopartida(Score.newScore(getApplicationContext()));
        GlobalVar.setSolution(SudokuSolutionOnedimension);
        GlobalVar.setRootview(findViewById(android.R.id.content));

        final int[] OnedimensionSudoku = Sudoku.ConvertoOneDimension(EmptySudoku);
        Grid = (GridView) findViewById(R.id.Graella);
        customAdapter = new SudokuAdapter(getApplicationContext(), OnedimensionSudoku);
        Grid.setAdapter(customAdapter);


        new ScoreUpdate(this, this.findViewById(R.id.activity_game)).execute();


        // GlobalVar.getPuntuaciopartida();

    }

    private int[] randomSudoku() {
       Random rand = new Random();
        return getResources().getIntArray(
                possibleSudokuId[(rand.nextInt(possibleSudokuId.length))
                        ]);
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

    public void onDestroy() {
        ScoreDbUtil Dbutils = new ScoreDbUtil(this);
        Dbutils.insert(GlobalVar.getPuntuaciopartida());
        //Dbutils.insertToCalendar(GlobalVar.getPuntuaciopartida(),this);
        afegirEvent(GlobalVar.getPuntuaciopartida());
        super.onDestroy();

    }

    private void afegirEvent(Score Puntuacio) {

        Calendar calendari = Calendar.getInstance();
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("beginTime", calendari.getTimeInMillis());
        intent.putExtra("allDay", true);
        intent.putExtra("rrule", "FREQ=YEARLY");
        intent.putExtra("endTime", calendari.getTimeInMillis() +  60 * 1000);
        intent.putExtra("title", "Puntuacio obtinguda Passatemps Sudoku");
        intent.putExtra("description", "Data: "+Puntuacio.getDate().toString()+" Puntuacio: "+Puntuacio.getValue());
        intent.putExtra("eventLocation", "Geolocacio");

        startActivityForResult(intent,1);
    }
}
