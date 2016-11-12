package edu.fje.clot.sudoku.matrix;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by m0r on 11/11/16.
 */

public class Cell extends View {
    private int number;
    private Paint npaint;
    public Cell(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    public void setNumber(int number){

        this.number=number;
    }
}
