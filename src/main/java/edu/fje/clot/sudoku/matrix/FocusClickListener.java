package edu.fje.clot.sudoku.matrix;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import edu.fje.clot.sudoku.R;
import edu.fje.clot.sudoku.globals.SudokuApplication;
import edu.fje.clot.sudoku.scores.Score;

import static android.content.ContentValues.TAG;

/**
 * Created by oriol on 11/19/16.
 */

public class FocusClickListener {
        public static String TextContent(View v){
            String text="";
            if (v instanceof EditText)

                text=  ((EditText)v).getText().toString();
            if (v instanceof TextView)
                text=  ((TextView)v).getText().toString();
            return text;
        }
 public static RelativeLayout GetRelativeLayoutFromGrid(RelativeLayout rel, int i){

     RelativeLayout rel2 =(RelativeLayout) ((ViewGroup) rel.getParent()).getChildAt(i);
     rel2.setBackgroundResource(R.drawable.cell_shape_focused);
     return rel2;
 }

    public static void PaintPosition(View v, final RelativeLayout rel,boolean listener,Context context ){

        final String text=TextContent(v);
        final int position = v.getId();
        // RelativeLayout rel = (RelativeLayout) v.findViewById(R.id.EmptyCell);
        rel.setBackgroundResource(R.drawable.cell_shape_focused);
        if (rel.getChildAt(0) instanceof TextView){
           ((TextView) rel.getChildAt(0)).setTextColor(Color.BLACK);
        }
        if (rel.getChildAt(0) instanceof EditText){
             ((EditText) rel.getChildAt(0)).setTextColor(Color.BLACK);
            ((EditText) rel.getChildAt(0)).setSelection(text.length());
        }
        for(int i=0; i<81; i++) {
            RelativeLayout rel2 = (RelativeLayout) ((ViewGroup) rel.getParent()).getChildAt(i);
            rel2.setBackgroundResource(R.drawable.cell_shape);
            if (rel2.getChildAt(0) instanceof TextView){
                  ((TextView) rel2.getChildAt(0)).setTextColor(Color.BLACK);
            }
            if (rel2.getChildAt(0) instanceof EditText){
               ((EditText) rel2.getChildAt(0)).setTextColor(Color.BLACK);
            }

        }
        for(int i= position-position%9; i<position+(9-position%9); i++) {
            final RelativeLayout rel2 = (RelativeLayout) ((ViewGroup) rel.getParent()).getChildAt(i);
            rel2.setBackgroundResource(R.drawable.cell_shape_focused);
            if (rel.getChildAt(0) instanceof EditText)

               if(listener) ErrorPaintListener( v, (EditText) rel.getChildAt(0), rel, rel2,text,context );

            Errorspainting(rel, rel2, text,i==position);

        }
        for(int i= position%9; i<81; i+=9) {
            RelativeLayout rel2 = (RelativeLayout) ((ViewGroup) rel.getParent()).getChildAt(i);
            rel2.setBackgroundResource(R.drawable.cell_shape_focused);
            //EditText edtxt= (EditText) v.findViewById(R.id.SudokuVariableNumber);
            //  edtxt.setBackgroundColor(Color.GREEN);
            if (rel.getChildAt(0) instanceof EditText)
                if(listener)   ErrorPaintListener( v, (EditText) rel.getChildAt(0), rel, rel2,text,context );
            Errorspainting(rel, rel2, text,i==position);
        }
        //int x=(position+1)/3;
        int Qx=((position)/3)%3;
        int Qy= (position/9)/3;
        // int miny=((position%9)/3)*3; int maxy = ((position%9)/3)*3+3;
        for(int i=0; i<81; i++) {

            int posx= i%9;
            if  ((Qx==((i)/3)%3)&&(Qy==(i/9)/3)){

                final RelativeLayout rel2 = GetRelativeLayoutFromGrid(rel,i);
                if (rel.getChildAt(0) instanceof EditText)
                    if(listener)    ErrorPaintListener( v, (EditText) rel.getChildAt(0), rel, rel2,text,context );
                Errorspainting(rel, rel2, text,i==position );
            }
        }


    }



    public static void FocusMaker(View v, final RelativeLayout rel,final Context context){

        v.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    PaintPosition(v,rel, true,context);
                }else{

                    // RelativeLayout rel = (RelativeLayout) v.findViewById(R.id.EmptyCell);
                    rel.setBackgroundResource(R.drawable.cell_shape);

                }

            }});

    }

private static void SumaPuntuacio(View v, Context context, RelativeLayout rel){


     SudokuApplication GlobalVar = (SudokuApplication) context;
    int position = v.getId();
        int[] solution = GlobalVar.getSolution();

     Score score = GlobalVar.getPuntuaciopartida();
    if (TextContent(v).equals(Integer.toString(solution[position])) ){
     score.ValueIncrement(40);Log.v("Suma","+60" );}
        else{
            score.ValueIncrement(-5);   Log.v("Resta","-5" ); }
     GlobalVar.setPuntuaciopartida(score);
     Log.v("TextContent",TextContent(v) );
    Log.v("Solucio",Integer.toString(solution[position]) );
     Application application = (Application)SudokuApplication.getContext();
     SudokuApplication app = (SudokuApplication)application;
     View parent = app.getRootview();
     TextView textView  = (TextView) parent.findViewById(R.id.TxtVScore);
     textView.setText(Integer.toString(app.getPuntuaciopartida().getValue()));



 }

    private static void Errorspainting(final RelativeLayout rel,final RelativeLayout rel2,final String text, boolean Mateixacasella) {
        if (rel2.getChildAt(0) instanceof EditText) {
            String text2="";

            if (rel.getChildAt(0)instanceof TextView){

            text2 = ((TextView) rel2.getChildAt(0)).getText().toString();

                if (text2.equals(text) && (!text2.equals("")) && (!Mateixacasella)) {
                    ((TextView) rel.getChildAt(0)).setTextColor(Color.RED);
                    rel2.setBackgroundResource(R.drawable.cell_shape_warning);


                }
            }
            if (rel.getChildAt(0)instanceof EditText){
               text2 = ((EditText) rel2.getChildAt(0)).getText().toString();


                if (text2.equals(text) && (!text2.equals("")) && (!Mateixacasella)) {
                    ((EditText) rel.getChildAt(0)).setTextColor(Color.RED);
                    rel2.setBackgroundResource(R.drawable.cell_shape_warning);

                }

            }


        } else if (rel2.getChildAt(0) instanceof TextView) {
            String text2 = ((TextView) rel2.getChildAt(0)).getText().toString();
            if (text2.equals(text) && (!text2.equals("")) && (!Mateixacasella))  {
                ((TextView) rel.getChildAt(0)).setTextColor(Color.RED);
                rel2.setBackgroundResource(R.drawable.cell_shape_warning);
            }
        }
    }

    public static void ErrorPaintListener(final View v, final EditText edtxt, final RelativeLayout rel, final RelativeLayout rel2, final String text, final Context context) {

        edtxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean mateixacela=(rel2.getChildAt(0)==edtxt);


                PaintPosition(v,rel, false,context);
                Errorspainting(rel, rel2,s.toString(),mateixacela);
                SumaPuntuacio(v,context,rel);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void afterTextChanged(Editable s) {
               Errorspainting(rel, rel2, text, false);
                //((EditText) rel.getChildAt(0)).setTextColor(Color.YELLOW);
            }
        });
    }

}
