package edu.fje.clot.sudoku.matrix;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import edu.fje.clot.sudoku.GameMotor;
import edu.fje.clot.sudoku.R;

/**
 * Created by oriol on 11/12/16.
 */

public class SudokuGridViewAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    public SudokuGridViewAdapter(Context context) {
        this.context=context;
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
                View v= view;

            if(v==null){
                inflater = ((Activity) context).getLayoutInflater();

                v = inflater.inflate(R.layout.cell,parent, false);
            }
            int x= position%9;
            int i=position/9;
        Cell cell = (Cell) v;
       // cell.setNumber(GameMotor);
        return v;
    }
}
