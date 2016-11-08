package edu.fje.clot.sudoku;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by oriol on 11/8/16.
 */

public class Puntuacio implements Comparable<Puntuacio>{
            private int punts;
            private GregorianCalendar Data;
            Puntuacio(int punts,GregorianCalendar Data){

                this.punts= punts;
                this.Data= Data;

            }


    @Override
    public int compareTo(Puntuacio puntuacio) {
       return (this.punts < puntuacio.punts ) ? -1: (this.punts< puntuacio.punts) ? 1:0;
    }
}
