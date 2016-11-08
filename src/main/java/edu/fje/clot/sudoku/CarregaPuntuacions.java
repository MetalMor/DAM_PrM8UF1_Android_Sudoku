package edu.fje.clot.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by oriol on 11/8/16.
 */


public class CarregaPuntuacions {
            ArrayList<Puntuacio> Llistapuntuats ;
              ArrayList<Puntuacio> TresMillors;
                CarregaPuntuacions(){
                    //De momento nos las inventamos
                    GregorianCalendar Data= new GregorianCalendar();
                   Data.set(2016,10,20,12,30,0);
                    Llistapuntuats.add(new Puntuacio(1000,Data));
                    Data.set(2016,9,30,11,30,0);
                    Llistapuntuats.add(new Puntuacio(1500,Data));
                    Data.set(2016,8,20,12,30,0);
                    Llistapuntuats.add(new  Puntuacio(400,Data));
                    Data.set(2016,10,10,11,10,0);
                    Llistapuntuats.add(new Puntuacio(700,Data));
                    TriaTresMillors();
                }

            public void TriaTresMillors(){
                TresMillors= Llistapuntuats;
                Collections.sort(TresMillors);
                for(int i=3;i<TresMillors.size();i++){
                        TresMillors.remove(i);
                }

            }


}
