package edu.fje.clot.sudoku.matrix;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by oriol on 11/8/16.
 */

public class Sudoku {
    private static Sudoku instance;

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    int[][] matrix= new int[9][9];
    private Random rand = new Random();
    public Sudoku(int[][] matrix) {
        this.matrix = matrix;
    }
    public Sudoku() {

    }

    public static Sudoku getInstance(){
        if( instance == null ){
            instance = new Sudoku();
        }
        return instance;
    }

    public static int[] ConvertoOneDimension(int[][] Bidimensional){
        int[] vector = new int[Bidimensional[0].length*Bidimensional.length];
        int n=0;
        for(int i=0;i<Bidimensional.length;i++){
            for (int k=0;k<Bidimensional[i].length;k++){
                vector[n]=Bidimensional[i][k];
                n++;
            }
        }
        return vector;
    }

    public static int[][] ConvertoTwoDimension(int[] matrix) {
        int length = (int) Math.sqrt(matrix.length);
        int[][] vector = new int[length][length];
        for(int i = 0, k = -1,j=0; i < matrix.length; i++) {
            if(i % length == 0){ k++; j=0;}
            vector[k][j] = matrix[i];
            j++;
        }
        return vector;
    }

    public int[][] ClearSudoku(int[][] sudoku,int Q){
        Random rand = new Random();
        int i =0;
        int Totalquadrat=(81-Q)/9;
        while(i<Q){
            int x=rand.nextInt(9);
            int y=rand.nextInt(9);
            if(sudoku[x][y]!=0&&elementsinsquash(sudoku,x,y)>Totalquadrat){
                sudoku[x][y]=0;
                i++;
            }
        }

    return sudoku;
    }
    public int elementsinsquash(int[][]sudoku,int x,int y){
        int minx=(x/3)*3; int maxx = (x/3)*3+3;
        int miny=(y/3)*3; int maxy = (y/3)*3+3;
        int nelements=0;
        for(int i=minx;i<maxx;i++){
            for (int k=miny;k<maxy;k++){
                if (sudoku[i][k]!=0)
                    nelements++;
            }
        }
        return nelements;
    }



}
