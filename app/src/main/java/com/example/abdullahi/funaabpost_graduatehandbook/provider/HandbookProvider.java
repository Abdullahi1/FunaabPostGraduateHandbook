package com.example.abdullahi.funaabpost_graduatehandbook.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

public class HandbookProvider extends ContentProvider {

    public static final int ADMISSION_REQUIREMENT = 5;
    public static final int GRADUATION_REQUIREMENT = 6;
    public static final int COURSE_DURATION = 7;
    public static final int STAFFS = 8;
    public static final int STAFF_ID = 9;
    public static final int PHDCOURSE = 10;
    private static final String AUTHORITY = "com.example.abdullahi.funaabpost_graduatehandbook.provider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    private static final int COURSES = 1;
    private static final int COURSE_ID = 2;
    private static final int SYNOPSIS = 3;
    private static final int SYNOPSIS_ID = 4;
    private static final String TAG = HandbookProvider.class.getName();
    private static final UriMatcher URI_MATCHER;

    static {
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(AUTHORITY, "courses", COURSES);
        URI_MATCHER.addURI(AUTHORITY, "courses/#", COURSE_ID);
        URI_MATCHER.addURI(AUTHORITY, "synopsis", SYNOPSIS);
        URI_MATCHER.addURI(AUTHORITY, "requirement", ADMISSION_REQUIREMENT);
        URI_MATCHER.addURI(AUTHORITY, "duration", COURSE_DURATION);
        URI_MATCHER.addURI(AUTHORITY, "staffs", STAFFS);
        URI_MATCHER.addURI(AUTHORITY, "staffs/#", STAFF_ID);
        URI_MATCHER.addURI(AUTHORITY, "phdCourses", PHDCOURSE);
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

        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        int match = URI_MATCHER.match(uri);
        switch (match) {
            case COURSES:
                return "vnd.android.cursor.dir/vnd.abdullahi.course";
            case SYNOPSIS:
            case COURSE_ID:
                return "vnd.android.cursor.item/vnd.abdullahi.course";
            case ADMISSION_REQUIREMENT:
                return "vnd.android.cursor.dir/vnd.abdullahi.requirement";
            case COURSE_DURATION:
                return "vnd.android.cursor.dir/vnd.abdullahi.duration";
            case STAFFS:
                return "vnd.android.cursor.dir/vnd.abdullahi.staff";
            case STAFF_ID:
                return "vnd.android.cursor.item/vnd.abdullahi.staff";
            case PHDCOURSE:
                return "vnd.android.cursor.dir/vnd.abdullahi.phdCourse";
            default:
                return null;
        }

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
