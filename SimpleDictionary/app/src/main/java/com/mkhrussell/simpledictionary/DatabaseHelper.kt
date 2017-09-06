package com.mkhrussell.simpledictionary

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(private var mContext: Context) : SQLiteOpenHelper(mContext, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private val DATABASE_NAME = "simple_dict2.db"
        private val DATABASE_VERSION = 1

        val TABLE_NAME = "english_words"

        val COLUMN_ID = "_id"
        val COLUMN_WORD = "word"
        val COLUMN_TYPE = "type"
        val COLUMN_MEANING = "meaning"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $TABLE_NAME ($COLUMN_ID INT, $COLUMN_WORD TEXT, $COLUMN_TYPE TEXT, $COLUMN_MEANING TEXT)");
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exist $TABLE_NAME")

        onCreate(db)
    }

    fun addWord() {

        // insert into english_words values(1, 'a', 'noun', 'First letter of english alphabet.');

        val contentValues = ContentValues()
        contentValues.put(COLUMN_ID, 1)
        contentValues.put(COLUMN_WORD, "b")
        contentValues.put(COLUMN_TYPE, "noun")
        contentValues.put(COLUMN_MEANING, "Second letter of english alphabet.")

        this.writableDatabase.insert(TABLE_NAME, null, contentValues)
    }
}