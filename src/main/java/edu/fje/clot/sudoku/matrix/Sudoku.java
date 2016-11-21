package edu.fje.clot.sudoku.matrix;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
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
        for(int i = 0, k = -1; i < matrix.length; i++) {
            if(i % length == 0) k++;
            vector[k][i] = matrix[i];
        }
        return vector;
    }



    public int[][] Load(){
        ArrayList<int[][]> AllSudokus = new ArrayList<int[][]>();

                int[][] sudoku1 =
                        {{4,7,8,9,5,3,1,2,6},
                        {3,1,6,7,4,2,8,9,5},
                        {5,9,2,6,1,8,7,3,4},
                        {6,5,7,2,3,1,9,4,8},
                        {1,3,9,4,8,7,6,5,2},
                        {8,2,4,5,6,9,3,7,1},
                        {7,6,3,8,2,5,4,1,9},
                        {9,4,5,1,7,6,2,8,3},
                        {2,8,1,3,9,4,5,6,7}};
        int[][] sudoku2 =
                        {{3,4,5,2,9,6,8,1,7},
                        {1,7,8,5,4,3,6,9,2},
                        {2,6,9,8,7,1,3,4,5},
                        {4,2,7,6,5,8,9,3,1},
                        {9,3,6,4,1,7,5,2,8},
                        {8,5,1,9,3,2,4,7,6},
                        {6,1,2,3,8,4,7,5,9},
                        {5,8,4,7,2,9,1,6,3},
                        {7,9,3,1,6,5,2,8,4}};
        int[][] sudoku3 =
                         {{2,8,3,6,7,4,9,1,5},
                        {5,9,7,8,1,3,2,6,4},
                        {4,1,6,2,5,9,7,3,8},
                        {8,6,2,9,4,5,3,7,1},
                        {3,4,1,7,8,2,6,5,9},
                        {7,5,9,1,3,6,8,4,2},
                        {1,2,4,3,9,7,5,8,6},
                        {9,3,5,4,6,8,1,2,7},
                        {6,7,8,5,2,1,4,9,3}};

        AllSudokus.add(sudoku1);
        AllSudokus.add(sudoku2);
        AllSudokus.add(sudoku3);
            return AllSudokus.get(rand.nextInt(AllSudokus.size()));
    }

    private int format(double number) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(0);
        nf.setRoundingMode(RoundingMode.UP);
        return Integer.parseInt(nf.format(number));
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
