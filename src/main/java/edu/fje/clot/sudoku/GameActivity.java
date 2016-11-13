package edu.fje.clot.sudoku;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import edu.fje.clot.sudoku.matrix.Sudoku;

import edu.fje.clot.sudoku.matrix.SudokuAdapter;
import edu.fje.clot.sudoku.matrix.TableLayoutAdapter;

/**
 * Created by oriol on 11/12/16.
 */

public class GameActivity extends Activity implements View.OnClickListener {
    int[][] SudokuSolution;
    int[][] EmptySudoku;
    TableLayoutAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SudokuSolution = Sudoku.getInstance().Load();
        EmptySudoku = Sudoku.getInstance().ClearSudoku(SudokuSolution);
        GameMotor gameMotor = new GameMotor();
        gameMotor.setSudoku(EmptySudoku);
        setContentView(R.layout.activity_game);
        /*TableLayout Table = (TableLayout) findViewById( R.id.TableSudoku);
           for(int i=0;i<9;i++){
                TableRow fila = new TableRow(this);
                fila.setId(i);int id=0;
                for(int k=0;k<9;k++){
                    if(EmptySudoku[i][k]==0){
                        EditText editnumber = new EditText(this);
                        editnumber.setInputType(InputType.TYPE_CLASS_NUMBER);
                        editnumber.setMaxEms(1);
                        editnumber.setWidth(60);
                        editnumber.setHeight(60);
                        editnumber.setBackgroundColor(Color.WHITE);
                        editnumber.setCompoundDrawablePadding(15);
                        InputFilter[] FilterArray = new InputFilter[1];
                        FilterArray[0] = new InputFilter.LengthFilter(1);
                        editnumber.setFilters(FilterArray);
                        editnumber.setId(id);
                        fila.addView(editnumber);

                  }
                    else{
                        TextView tv = new TextView(this);
                        tv.setText(Integer.toString(EmptySudoku[i][k]));
                        tv.setWidth(80);
                        tv.setHeight(80);
                        tv.setCompoundDrawablePadding(15);
                        tv.setBackgroundColor(Color.WHITE);
                        fila.addView(tv);

                    }

                    id++;

                }Table.addView(fila);}

                 */
        int[] OnedimensionSudoku =Sudoku.ConvertoOneDimension(EmptySudoku);
        GridView   Grid = (GridView) findViewById(R.id.simpleGridView);
        SudokuAdapter customAdapter = new SudokuAdapter(getApplicationContext(),OnedimensionSudoku);
        Grid.setAdapter(customAdapter);

/*        final TableLayout Table = (T ableLayout) findViewById( R.id.TableSudoku);
        adapter = new TableLayoutAdapter(this, EmptySudoku);
        TableLayout.setAdapter(adapter);
*/
    }

    @Override
    public void onClick(View view) {

    }
}
