package edu.fje.clot.sudoku.scores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
//import android.R;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import edu.fje.clot.sudoku.R;
import edu.fje.clot.sudoku.scores.mask.IScores;

/**
 * Created by oriol on 11/12/16.
 */

public class ScoreAdapter extends BaseAdapter{
    // Declare Variables
    private Context context;
    private IScores Puntuacions;
    private int[] imatges;
    private LayoutInflater inflater;

    public ScoreAdapter(Context context, IScores Puntuacions, int[] imatges) {
        this.context = context;
        this.Puntuacions = Puntuacions;
        this.imatges=imatges;
    }

    public int getCount() {
        return Puntuacions.count();
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
        Score puntuacio =Puntuacions.getItem(position);
        // Capture position and set to the TextViews
        int punts=puntuacio.getValue();
        txtScore.setText(Integer.toString(punts));
        SimpleDateFormat formatdata = new SimpleDateFormat("dd-MM-yyyy");
        txtDate.setText(formatdata.format(puntuacio.getDate()));
        if(position<3) imgImg.setImageResource(imatges[position]);

        return itemView;
    }
}