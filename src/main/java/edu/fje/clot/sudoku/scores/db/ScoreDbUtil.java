package edu.fje.clot.sudoku.scores.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import edu.fje.clot.sudoku.scores.Score;

/**
 * Created by m0r on 21/11/16.
 */

public class ScoreDbUtil extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Score.db";
    private static final int DATABASE_VERSION = 1;
    private static final String ORDER = ScoreContract.ScoreTable.COLUMN_VALUE + " DESC";
    private static final String[] QUERY_PROJECTION = {
            ScoreContract.ScoreTable._ID,
            ScoreContract.ScoreTable.COLUMN_DATE,
            ScoreContract.ScoreTable.COLUMN_VALUE
    };
    private static final String[] QUERY_COUNT = { ScoreContract.ScoreTable.COUNT };
    private static final String[] QUERY_MAX_ID = { ScoreContract.ScoreTable.MAX_ID };
    private static final String BY_ID = ScoreContract.ScoreTable._ID + "=?";

    private static final String SQL_CREATE_TABLE = "CREATE TABLE " +
            ScoreContract.ScoreTable.TABLE_NAME + " (" +
            ScoreContract.ScoreTable._ID + " INTEGER PRIMARY KEY, " +
            ScoreContract.ScoreTable.COLUMN_DATE + " LONG DEFAULT 0, " +
            ScoreContract.ScoreTable.COLUMN_VALUE + " INTEGER DEFAULT 0)";
    private static final String SQL_DROP_TABLE_IF_EXISTS = "DROP TABLE IF EXISTS " + ScoreContract.ScoreTable.TABLE_NAME;

    public ScoreDbUtil(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public boolean insert(Score score) {
        ContentValues values = new ContentValues();
        values.put(ScoreContract.ScoreTable._ID, score.getId());
        values.put(ScoreContract.ScoreTable.COLUMN_VALUE, score.getValue());
        values.put(ScoreContract.ScoreTable.COLUMN_DATE, score.getDate().getTime());
        return getWritableDatabase().insert(
                        ScoreContract.ScoreTable.TABLE_NAME,
                        ScoreContract.ScoreTable.COLUMN_NULL,
                        values
                ) >= 0;
    }

    public boolean insertAll(List<Score> scores) {
        boolean result = true;
        Collections.sort(scores);
        for(Score score : scores)
            result &= insert(score);
        return result;
    }

    public Score find(int _id) {
        String[] args = { String.valueOf(_id) };
        Cursor cursor = getReadableDatabase().query(ScoreContract.ScoreTable.TABLE_NAME,
                QUERY_PROJECTION, BY_ID, args, null, null, null);
        Score result = null;
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            result = new Score(
                    cursor.getInt(cursor.getColumnIndex(ScoreContract.ScoreTable._ID)),
                    cursor.getInt(cursor.getColumnIndex(ScoreContract.ScoreTable.COLUMN_VALUE)),
                    new Date(cursor.getLong(cursor.getColumnIndex(ScoreContract.ScoreTable.COLUMN_DATE)))
            );
        }
        cursor.close();
        return result;
    }

    public int count() {
        Cursor cursor = getReadableDatabase().query(ScoreContract.ScoreTable.TABLE_NAME,
                QUERY_COUNT, null, null, null, null, null);
        cursor.moveToFirst();
        int result = cursor.getInt(cursor.getColumnIndex(ScoreContract.ScoreTable.COUNT));
        cursor.close();
        return result;
    }

    public int findMaxId() {
        Cursor cursor = getReadableDatabase().query(ScoreContract.ScoreTable.TABLE_NAME,
                QUERY_MAX_ID, null, null, null, null, null);
        cursor.moveToFirst();
        int result = cursor.getInt(cursor.getColumnIndex(ScoreContract.ScoreTable.MAX_ID));
        cursor.close();
        return result;
    }

    public List<Score> findAll() {
        List<Score> result = new ArrayList<>();
        Cursor cursor = getReadableDatabase().query(ScoreContract.ScoreTable.TABLE_NAME,
                QUERY_PROJECTION, null, null, null, null, ORDER);
        // 1 -> ID, 2 -> DATE, 3 -> VALUE
        if(cursor.getCount() > 0)
            for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
                result.add(new Score(
                        cursor.getInt(cursor.getColumnIndex(ScoreContract.ScoreTable._ID)),
                        cursor.getInt(cursor.getColumnIndex(ScoreContract.ScoreTable.COLUMN_VALUE)),
                        new Date(cursor.getLong(cursor.getColumnIndex(ScoreContract.ScoreTable.COLUMN_DATE)))
                ));
        cursor.close();
        return result;
    }

    public List<Score> findTop(int top) {
        List<Score> result = new ArrayList<>();
        final String LIMIT = " LIMIT" + top;
        Cursor cursor = getReadableDatabase().query(ScoreContract.ScoreTable.TABLE_NAME,
                QUERY_PROJECTION, null, null, null, null, ORDER, LIMIT);
        // 1 -> ID, 2 -> DATE, 3 -> VALUE
        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
            result.add(new Score(
                    cursor.getInt(cursor.getColumnIndex(ScoreContract.ScoreTable._ID)),
                    cursor.getInt(cursor.getColumnIndex(ScoreContract.ScoreTable.COLUMN_VALUE)),
                    new Date(cursor.getLong(cursor.getColumnIndex(ScoreContract.ScoreTable.COLUMN_DATE)))
            ));
        cursor.close();
        return result;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //sqLiteDatabase.execSQL("DROP TABLE " + ScoreContract.ScoreTable.TABLE_NAME);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DROP_TABLE_IF_EXISTS);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onUpgrade(sqLiteDatabase, i, i1);
    }
}
