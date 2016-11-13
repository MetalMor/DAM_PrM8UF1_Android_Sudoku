package edu.fje.clot.sudoku.matrix;

/**
 * Created by oriol on 11/13/16.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.InputFilter;
import android.text.InputType;
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



            if (sudoku1dimension[i]==0){
              /*  EditText editnumber = new EditText(context);
                editnumber.setInputType(InputType.TYPE_CLASS_NUMBER);
                editnumber.setMaxEms(1);
             //   editnumber.setWidth(60);
              //  editnumber.setHeight(60);
                editnumber.setBackgroundColor(Color.WHITE);
                editnumber.setCompoundDrawablePadding(15);
                InputFilter[] FilterArray = new InputFilter[1];
                FilterArray[0] = new InputFilter.LengthFilter(1);
                editnumber.setFilters(FilterArray);
                editnumber.setText(Integer.toString(sudoku1dimension[i]));
                editnumber.setId(i);
                view = inflter.inflate(R.layout.filledcell, null);
                editnumber.setText("h");
                */
                view = inflter.inflate(R.layout.emptycell, null);
                EditText edtxt = (EditText) view.findViewById(R.id.SudokuVariableNumber);
                edtxt.setText("");
            }else {
                view = inflter.inflate(R.layout.filledcell, null);
                TextView txtview = (TextView) view.findViewById(R.id.SudokuNumberFix);
                txtview.setText(Integer.toString(sudoku1dimension[i]));
            }



        return view;
    }
}