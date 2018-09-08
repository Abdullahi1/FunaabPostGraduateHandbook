package com.example.abdullahi.funaabpost_graduatehandbook.provider;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.abdullahi.funaabpost_graduatehandbook.R;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class HandbookDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = HandbookDatabaseHelper.class.getName();
    private static final String DATABASE_NAME = "handbook.db";
    private static final int DB_VERSION = 1;
    private final Context context;
    private SQLiteDatabase database;

    HandbookDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private String databasePath(){
        return context.getDatabasePath(DATABASE_NAME).getAbsolutePath();
    }

    public void createDatabase() throws IOException{
        boolean exists = checkDatabase();
       // if (!exists){
            database = getReadableDatabase();
            try {
                copyDatabase();
            }
            catch (IOException e) {
                throw new Error("Error copying database");
            }

            if (database != null) {
                database.close();
                database = null;
            }
    //}
    }

    private boolean checkDatabase(){
        SQLiteDatabase checkDB = null;
        try {
            String path = databasePath();
            checkDB = SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READONLY);

        }catch (SQLException e){
            Log.e(TAG,"Database Does not Exist");
        }

        if (checkDB != null){
            checkDB.close();
        }

        return (checkDB !=null);
    }

    private void copyDatabase() throws IOException {
        String destination = databasePath();
        OutputStream output  = new FileOutputStream(destination);
        //int [] resources = new int[]{};
        int resources = R.raw.book;

//        for (int resource : resources){
//            InputStream input = context.getResources()
//                    .openRawResource(resource);
//
//        byte [] buffer = new byte[1024];
//        int length;
//        while ((length = input.read(buffer)) > 0){
//            output.write(buffer,0,length);
//        }
        InputStream input = context.getResources()
                .openRawResource(resources);

        byte [] buffer = new byte[1024];

        int length;

        while ((length = input.read(buffer)) > 0) {
            output.write(buffer, 0, length);
        }

        output.flush();

        input.close();

    output.close();
    }

    public SQLiteDatabase openDatabase() {
        String path = databasePath();
        database = SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READONLY);
        return database;
    }

    public  synchronized void  close(){
        if (database != null){
            database.close();
        }
        super.close();

    }


}
