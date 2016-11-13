package edu.fje.clot.sudoku.matrix;

/**
 * Created by oriol on 11/13/16.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import edu.fje.clot.sudoku.R;


public class SudokuAdapter extends BaseAdapter {
    Context context;
    int sudoku1dimension[];
    LayoutInflater inflter;

    public SudokuAdapter(Context applicationContext, int[] sudoku1dimension) {
        this.context = applicationContext;
        this.sudoku1dimension = sudoku1dimension;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return sudoku1dimension.length;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.filledcell, null);
        TextView editText = (TextView) view.findViewById(R.id.SudokuNumberFix);
        editText.setText(Integer.toString(sudoku1dimension[i]));
        return view;
    }
}