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
import android.widget.RelativeLayout;
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

                view = inflter.inflate(R.layout.emptycell, null);
                final EditText edtxt = (EditText) view.findViewById(R.id.SudokuVariableNumber);
                final RelativeLayout rel = (RelativeLayout) view.findViewById(R.id.EmptyCell);
                edtxt.setText("");
                edtxt.setId(i);

               rel.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) {
                            final int position = v.getId();
                           // RelativeLayout rel = (RelativeLayout) v.findViewById(R.id.EmptyCell);
                          //rel.setBackgroundColor(Color.GREEN);
                            EditText edtxt= (EditText) v.findViewById(R.id.SudokuVariableNumber);
                            edtxt.setBackgroundColor(Color.GREEN);

                        }else{

                            RelativeLayout rel = (RelativeLayout) v.findViewById(R.id.EmptyCell);
                            rel.setBackgroundColor(Color.WHITE);

                        }
                    }});
            }else {
                view = inflter.inflate(R.layout.filledcell, null);
                final TextView txtview = (TextView) view.findViewById(R.id.SudokuNumberFix);
                txtview.setText(Integer.toString(sudoku1dimension[i]));
                txtview.setId(i);
                txtview.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) {
                            final int position = v.getId();

                            txtview.setBackgroundColor(Color.GREEN);
                        }else{

                            txtview.setBackgroundColor(Color.WHITE);

                        }
                    }});
            }



        //we need to update adapter once we finish with editing


        return view;
    }
}