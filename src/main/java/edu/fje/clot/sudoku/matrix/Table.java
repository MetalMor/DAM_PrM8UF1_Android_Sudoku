package edu.fje.clot.sudoku.matrix;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;

/**
 * Created by oriol on 11/12/16.
 */

public class Table {


    private TableLayout table; // Layout donde se pintará la tabla
    private ArrayList<TableRow> rows; // Array de las filas de la tabla
    private Activity activity;
    private Resources rs;
    private int FILAS, COLUMNAS; // Filas y columnas de nuestra tabla

    public Table(Activity activity, TableLayout table)
    {
        this.activity = activity;
        this.table = table;
        rs = this.activity.getResources();
        FILAS = COLUMNAS = 9;
        rows = new ArrayList<TableRow>();
    }
}
