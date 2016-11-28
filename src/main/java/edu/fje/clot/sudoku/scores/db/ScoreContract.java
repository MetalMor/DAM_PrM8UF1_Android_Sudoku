package edu.fje.clot.sudoku.scores.db;

import android.provider.BaseColumns;

/**
 * Created by m0r on 20/11/16.
 */

final class ScoreContract {
    static abstract class ScoreTable implements BaseColumns {
        static final String TABLE_NAME = "SCORE";
        static final String COLUMN_DATE = "DATE";
        static final String COLUMN_VALUE = "VALUE";
        static final String COLUMN_NULL = "NULL";
        static final String COUNT = "COUNT(*)";
        static final String MAX_ID = "MAX(" + _ID + ")";
    }
}
