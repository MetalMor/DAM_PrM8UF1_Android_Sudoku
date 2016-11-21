package edu.fje.clot.sudoku.scores.db;

import android.provider.BaseColumns;

/**
 * Created by m0r on 20/11/16.
 */

final class ScoreContract {
    public static abstract class ScoreTable implements BaseColumns {
        public static final String TABLE_NAME = "SCORE";
        public static final String COLUMN_DATE = "DATE";
        public static final String COLUMN_VALUE = "VALUE";
        public static final String COLUMN_NULL = "NULL";
        public static final String COUNT = "COUNT(*)";
    }
}
