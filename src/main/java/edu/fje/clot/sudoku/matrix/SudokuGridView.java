package edu.fje.clot.sudoku.matrix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by oriol on 11/12/16.
 */

public class SudokuGridView extends GridView{
   private  Context  context ;
    public SudokuGridView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        SudokuGridViewAdapter gridViewAdapter = new SudokuGridViewAdapter(context);
        setAdapter(gridViewAdapter);
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int x=position%9;
                int y=position/9;

            //   Toast toast = Toast.makeText(context,"x: " + x + " y:" + y,Toast.LENGTH_SHORT).show();

            }}
            );}

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
