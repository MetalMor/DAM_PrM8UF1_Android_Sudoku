package edu.fje.clot.sudoku.matrix;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import edu.fje.clot.sudoku.GameMotor;
import edu.fje.clot.sudoku.R;

/**
 * Created by oriol on 11/12/16.
 */

public class TableLayoutAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    private int[][] sudoku;
    public TableLayoutAdapter(Context context, int[][] sudoku) {
        this.context=context;
        this.sudoku=sudoku;
    }

    @Override
    public int getCount() {
        return 81;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
                View vista= view;
        int x= position%9;
        int y=position/9;
        TextView numeroTXT;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (sudoku[x][y]>0&&sudoku[x][y]<=9) {

            vista = inflater.inflate(R.layout.filledcell, parent, false);
            numeroTXT = (TextView) vista.findViewById(R.id.SudokuNumberFix);
            numeroTXT.setText(Integer.toString(sudoku[x][y]));

        }
        else{

        }
        vista = inflater.inflate(R.layout.emptycell, parent, false);



          return vista;
    }
}
