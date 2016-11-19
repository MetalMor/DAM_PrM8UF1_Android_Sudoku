package edu.fje.clot.sudoku.matrix;

/**
 * Created by oriol on 11/13/16.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
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

             edtxt.setId(i);
                FocusClickListener.FocusMaker(edtxt,rel );
              //  FocusClickListener.ErrorPaintListener( (EditText) rel.getChildAt(0), rel, rel2,text);

            }else {
                view = inflter.inflate(R.layout.filledcell, null);
                final TextView txtview = (TextView) view.findViewById(R.id.SudokuNumberFix);
                txtview.setText(Integer.toString(sudoku1dimension[i]));
                txtview.setId(i);
                final RelativeLayout rel = (RelativeLayout) view.findViewById(R.id.FilledCell);

                FocusClickListener.FocusMaker(txtview,rel );

            }



        //we need to update adapter once we finish with editing


        return view;
    }


}