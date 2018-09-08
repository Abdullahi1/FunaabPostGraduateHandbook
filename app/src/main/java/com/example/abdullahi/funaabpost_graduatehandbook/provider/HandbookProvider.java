package com.example.abdullahi.funaabpost_graduatehandbook.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;
import java.util.Objects;

public class HandbookProvider extends ContentProvider {

    public static final int PROGRAM = 1;
    public static final int SEMESTER = 3;
    private static final String AUTHORITY = "com.example.abdullahi.funaabpost_graduatehandbook";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    private static final int PROGRAM_ID = 2;
    private static final int SEMESTER_ID = 4;
    private static final int COURSE = 5;
    private static final int COURSE_ID = 6;
    private static final int SYNOPSIS = 7;
    private static final int SYNOPSIS_ID = 8;
    private static final String TAG = HandbookProvider.class.getName();
    private static final UriMatcher URI_MATCHER;

    static {
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

        URI_MATCHER.addURI(AUTHORITY, "program/#", PROGRAM_ID);
        URI_MATCHER.addURI(AUTHORITY, "program/#/semester/#", SEMESTER_ID);
        URI_MATCHER.addURI(AUTHORITY, "program/#/semester/#/course", COURSE);
        //URI_MATCHER.addURI(AUTHORITY, "course", COURSE);
        URI_MATCHER.addURI(AUTHORITY, "program/#/semester/#/course/#", COURSE_ID);
        URI_MATCHER.addURI(AUTHORITY, "program/#/semester/#/synopsis", SYNOPSIS);
        URI_MATCHER.addURI(AUTHORITY, "program/#/course/#/synopsis/#", SYNOPSIS_ID);
        // URI_MATCHER.addURI(AUTHORITY, "course", COURSE);
        //URI_MATCHER.addURI(AUTHORITY, "course", 1);
    }

    private HandbookDatabaseHelper dbHelper;

    @Override
    public boolean onCreate() {
        dbHelper = new HandbookDatabaseHelper(getContext());

        try {
            dbHelper.createDatabase();
            return true;
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
            return false;
        }

    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        int match = URI_MATCHER.match(uri);
        switch (match) {
            case PROGRAM_ID:
            case SEMESTER_ID:
            case COURSE:
                SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
                SQLiteDatabase sqlDB = dbHelper.getReadableDatabase();
                builder.setTables("course");
                Cursor c = builder.query(sqlDB, projection, selection, selectionArgs, null, null, sortOrder);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    c.setNotificationUri(Objects.requireNonNull(getContext()).getContentResolver(), uri);
                }
                return c;


        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {

        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
