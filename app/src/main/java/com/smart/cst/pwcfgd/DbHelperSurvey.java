package com.smart.cst.pwcfgd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by ravi on 15/03/18.
 */

public class DbHelperSurvey extends SQLiteOpenHelper {


    public static final String TABLE_NAME = "survey";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_STUDENT_ID = "student_id";
    public static final String COLUMN_DATA = "data";


    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "survey_db";


    public DbHelperSurvey(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // create notes table
        db.execSQL(CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insertSurvey(String id, String studentId, String data) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(COLUMN_ID, id);
        values.put(COLUMN_STUDENT_ID, studentId);
        values.put(COLUMN_DATA, data);

        // insert row
        long idReturn = db.insert(TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return idReturn;
    }

    public SurveyData getSurvey(String id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,
                new String[]{COLUMN_ID, COLUMN_STUDENT_ID, COLUMN_DATA},
                COLUMN_ID + "=?",
                new String[]{id}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        SurveyData note = new SurveyData(
                cursor.getString(cursor.getColumnIndex(COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(COLUMN_STUDENT_ID)),
                cursor.getString(cursor.getColumnIndex(COLUMN_DATA)));

        // close the db connection
        cursor.close();

        return note;
    }

    public List<FGDNewBean> getAllNotes() {
        List<FGDNewBean> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                String data = cursor.getString(cursor.getColumnIndex(COLUMN_DATA));
                FGDNewBean survey = new Gson().fromJson(data, FGDNewBean.class);
                survey.setId(cursor.getString(cursor.getColumnIndex(COLUMN_ID)));
                notes.add(survey);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }


    public ArrayList<FGDNewBean> getStudentsNotes(String studentId) {
        ArrayList<FGDNewBean> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME+" WHERE "+COLUMN_STUDENT_ID+"='"+studentId+"'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                String data = cursor.getString(cursor.getColumnIndex(COLUMN_DATA));
                FGDNewBean survey = new Gson().fromJson(data, FGDNewBean.class);
                survey.setId(cursor.getString(cursor.getColumnIndex(COLUMN_ID)));
                notes.add(survey);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public ArrayList<FGDNewBean> getAllNotes(String studentId) {
        ArrayList<FGDNewBean> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                String data = cursor.getString(cursor.getColumnIndex(COLUMN_DATA));
                FGDNewBean survey = new Gson().fromJson(data, FGDNewBean.class);
                survey.setId(cursor.getString(cursor.getColumnIndex(COLUMN_ID)));
                notes.add(survey);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateNote(String id, String studentId, String data) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, id);
        values.put(COLUMN_STUDENT_ID, studentId);
        values.put(COLUMN_DATA, data);

        // updating row
        return db.update(TABLE_NAME, values, COLUMN_ID + " = ?",
                new String[]{id});
    }

    public void deleteNote(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?",
                new String[]{id});
        db.close();
    }


    // Create table
    // SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " TEXT,"
                    + COLUMN_STUDENT_ID + " TEXT,"
                    + COLUMN_DATA + " TEXT"
                    + ")";
}
