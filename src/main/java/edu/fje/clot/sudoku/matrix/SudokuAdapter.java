package edu.fje.clot.sudoku.matrix;

/**
 * Created by oriol on 11/13/16.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
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
        return sudoku1dimension[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int Q = getSquarePosition(i);
        if (sudoku1dimension[i]==0){
            view = inflter.inflate(R.layout.emptycell, null);
            final EditText edtxt = (EditText) view.findViewById(R.id.SudokuVariableNumber);
            final RelativeLayout rel = (RelativeLayout) view.findViewById(R.id.EmptyCell);
            if (Q%2==0)
               rel.setBackgroundResource(R.drawable.cell_shapeblue);
            edtxt.setId(i);
            Util.FocusMaker(edtxt,rel,context );

        } else {
            view = inflter.inflate(R.layout.filledcell, null);
            final TextView txtview = (TextView) view.findViewById(R.id.SudokuNumberFix);
            txtview.setText(Integer.toString(sudoku1dimension[i]));
            txtview.setId(i);
            final RelativeLayout rel = (RelativeLayout) view.findViewById(R.id.FilledCell);
            if (Q%2==0)
                rel.setBackgroundResource(R.drawable.cell_shapeblue);
            Util.FocusMaker(txtview,rel,context);

        }
        return view;
    }

    /**
     * Retorna la posicio del quadrant del sudoku en funcio de l'index especificat.
     * @param index int
     * @return int
     */
    private static int getSquarePosition(int index) {
        return (((index/3)%3)+1)+3*(((index/9)/3)+1);
    }

}