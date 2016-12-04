package edu.fje.clot.sudoku.matrix;

import java.util.Random;

/**
 * Classe que representa un sudoku.
 * Created by oriol on 11/8/16.
 */

public class Sudoku {

    private static Sudoku instance;
    private Random rand = new Random();

    /**
     * Constructor privat buit
     */
    private Sudoku() { }

    /**
     * Retorna l'objecte sudoku (unic). Si no existeix, el crea.
     * @return Sudoku
     */
    public static Sudoku getInstance(){
        if( instance == null ){
            instance = new Sudoku();
        }
        return instance;
    }

    /**
     * Transforma una matriu sudoku bidimensional en una unidimensional.
     * @param Bidimensional int[][]
     * @return int[]
     */
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

    /**
     * Transforma una matriu sudoku unidimensional en una bidimensional
     * @param matrix int[]
     * @return int[][]
     */
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

    /**
     * Elimina una quantitat Q de nombres a una matriu bidimensional sudoku.
     * @param sudoku int[][]
     * @param Q int
     * @return int[][]
     */
    public int[][] ClearSudoku(int[][] sudoku,int Q) {
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

    /**
     * Retorna el nombre d'elements existents a una seccio de
     * la matriu sudoku.
     * @param sudoku int[][]
     * @param x int
     * @param y int
     * @return int
     */
    private int elementsinsquash(int[][]sudoku,int x,int y){
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
