package edu.fje.clot.sudoku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
//import android.R;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by oriol on 11/12/16.
 */

public class ScoreAdapter extends BaseAdapter{
    // Declare Variables
    Context context;
    Scores Puntuacions;
    int[] imatges;
    LayoutInflater inflater;

    public ScoreAdapter(Context context,  Scores Puntuacions, int[] imatges) {
        this.context = context;
        this.Puntuacions = Puntuacions;
        this.imatges=imatges;
    }

  public int getCount() {
        return Puntuacions.NumerodePuntuacions();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Declare Variables
        TextView txtScore;
        TextView txtDate;
        ImageView imgImg;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.scorelist_item,parent, false);

        // Locate the TextViews in listview_item.xml
        txtScore = (TextView) itemView.findViewById(R.id.item_score);
        txtDate = (TextView) itemView.findViewById(R.id.item_date);
        imgImg = (ImageView) itemView.findViewById(R.id.item_image);
        Score puntuacio =Puntuacions.getAnOrdenadeIndexTop(position);
        // Capture position and set to the TextViews
        int punts=puntuacio.getValue();
        txtScore.setText(Integer.toString(punts));
        SimpleDateFormat formatdata = new SimpleDateFormat("dd-MM-yyyy");
        txtDate.setText(formatdata.format(puntuacio.getDate()));
        if(position<3) imgImg.setImageResource(imatges[position]);

        return itemView;
    }
}