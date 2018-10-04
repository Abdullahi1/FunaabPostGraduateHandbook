package com.example.abdullahi.funaabpost_graduatehandbook.provider;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.abdullahi.funaabpost_graduatehandbook.data.AcademicStaff;
import com.example.abdullahi.funaabpost_graduatehandbook.data.Course;
import com.example.abdullahi.funaabpost_graduatehandbook.data.CourseSynopsis;
import com.example.abdullahi.funaabpost_graduatehandbook.data.ProgramDuration;
import com.example.abdullahi.funaabpost_graduatehandbook.data.Requirement;
import com.example.abdullahi.funaabpost_graduatehandbook.data.ResearchBenchmark;

import java.util.ArrayList;
import java.util.List;

public class HandbookLibrary {


    private static final String TAG = HandbookLibrary.class.getName();

    public static List<Course> getCoursesForPhD(Context context, int semesterID, int programID) {
        List<Course> courses = new ArrayList<>();
        courses.clear();

        Cursor cursor = null;
        try {
            try {

                cursor = getPhDCourseCursor(context, semesterID, programID);

                while (cursor.moveToNext()) {
                    String courseName = cursor.getString(cursor.getColumnIndex(Course.course_name));
                    courses.add(new Course(
                            courseName));
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }


        return courses;
    }

    public static List<Course> getCourses(Context context, int semesterID, int programID) {
        List<Course> courses = new ArrayList<>();
        courses.clear();

        Cursor cursor = null;
        try {
            try {

                cursor = getCourseCursor(context, semesterID, programID);

                while (cursor.moveToNext()) {
                    int columnId = cursor.getInt(cursor.getColumnIndex(Course.ID));
                    String courseName = cursor.getString(cursor.getColumnIndex(Course.course_name));
                    String courseCode = cursor.getString(cursor.getColumnIndex(Course.course_code));
                    String courseAbbreviation = cursor.getString(cursor.getColumnIndex(Course.course_abbreviation));
                    int courseUnit = cursor.getInt(cursor.getColumnIndex(Course.course_unit));
                    courses.add(new Course(columnId,
                            courseCode,
                            courseName,
                            courseAbbreviation,
                            courseUnit));
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }

        return courses;
    }

    public static List<CourseSynopsis> getSynopsis(Context context, int courseID) {
        List<CourseSynopsis> synopsis = new ArrayList<>();
        synopsis.clear();

        Cursor cursor = null;
        try {
            try {
                cursor = getSynopsisCursor(context, courseID);

                while (cursor.moveToNext()) {
                    int columnId = cursor.getInt(cursor.getColumnIndex(CourseSynopsis.synopsis_id));
                    String synopsisName = cursor.getString(cursor.getColumnIndex(CourseSynopsis.synopsis_name));
                    synopsis.add(new CourseSynopsis(columnId,
                            synopsisName));
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }


        return synopsis;
    }

    public static List<Requirement> getRequirement(Context context, int requirementID, int programID) {
        List<Requirement> requirement = new ArrayList<>();
        requirement.clear();

        Cursor cursor = null;
        try {
            try {
                cursor = getRequirementCursor(context, requirementID, programID);

                while (cursor.moveToNext()) {
                    int columnId = cursor.getInt(cursor.getColumnIndex(Requirement.requirement_id));
                    String requirementName = cursor.getString(cursor.getColumnIndex(Requirement.requirement_name));
                    requirement.add(new Requirement(columnId,
                            requirementName));
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }


        return requirement;
    }

    public static List<ProgramDuration> getDuration(Context context, int programID) {

        List<ProgramDuration> durations = new ArrayList<>();
        durations.clear();

        Cursor cursor = null;
        try {
            try {
                cursor = getDurationCursor(context, programID);

                while (cursor.moveToNext()) {
                    int columnId = cursor.getInt(cursor.getColumnIndex(ProgramDuration.duration_id));
                    String durationName = cursor.getString(cursor.getColumnIndex(ProgramDuration.duration_name));
                    durations.add(new ProgramDuration(columnId,
                            durationName));
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }


        return durations;
    }

    public static List<ResearchBenchmark> getBenchmark(Context context, int programID) {

        List<ResearchBenchmark> benchmarkList = new ArrayList<>();
        benchmarkList.clear();

        Cursor cursor = null;
        try {
            try {
                cursor = getBenchmarkCursor(context, programID);

                while (cursor.moveToNext()) {
                    int columnId = cursor.getInt(cursor.getColumnIndex(ResearchBenchmark.benchmark_id));
                    String benchmarkName = cursor.getString(cursor.getColumnIndex(ResearchBenchmark.benchmark_name));
                    benchmarkList.add(new ResearchBenchmark(columnId,
                            benchmarkName));
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }


        return benchmarkList;
    }

    public static List<AcademicStaff> getStaff(Context context) {

        List<AcademicStaff> staffList = new ArrayList<>();
        staffList.clear();

        Cursor cursor = null;
        try {
            try {
                cursor = getStaffCursor(context);

                while (cursor.moveToNext()) {
                    int columnId = cursor.getInt(cursor.getColumnIndex(AcademicStaff.staff_id));
                    String staffName = cursor.getString(cursor.getColumnIndex(AcademicStaff.staff_name));
                    int rank = cursor.getInt(cursor.getColumnIndex(AcademicStaff.staff_rank));
                    String qualification = cursor.getString(cursor.getColumnIndex(AcademicStaff.staff_qualification));
                    String specialization = cursor.getString(cursor.getColumnIndex(AcademicStaff.staff_specialization));
                    staffList.add(new AcademicStaff(columnId,
                            staffName, rank, specialization, qualification));
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }


        return staffList;
    }

    public static AcademicStaff getSpecificStaff(Context context, int staffID) {

        AcademicStaff staff = null;

        Cursor cursor = null;
        try {
            try {
                cursor = getSpecificStaffCursor(context, staffID);

                while (cursor.moveToNext()) {
                    int columnId = cursor.getInt(cursor.getColumnIndex(AcademicStaff.staff_id));
                    String staffName = cursor.getString(cursor.getColumnIndex(AcademicStaff.staff_name));
                    int rank = cursor.getInt(cursor.getColumnIndex(AcademicStaff.staff_rank));
                    String qualification = cursor.getString(cursor.getColumnIndex(AcademicStaff.staff_qualification));
                    String specialization = cursor.getString(cursor.getColumnIndex(AcademicStaff.staff_specialization));
                    staff = new AcademicStaff(columnId,
                            staffName, rank, specialization, qualification);
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }


        return staff;
    }


    private static Cursor getCourseCursor(Context context, int semesterID, int programID) {
        String semesterIDString = String.valueOf(semesterID);
        String programIDString = String.valueOf(programID);
        String courseQuery = "SELECT "
                + Course.ID + "," + Course.course_name + "," + Course.course_code + ","
                + Course.course_abbreviation + "," + Course.course_unit + "," + Course.course_type_id +
                " FROM course WHERE " + Course.program_id + " = " + programIDString +
                " AND " + Course.semester_id + " = " + semesterIDString;

        HandbookDatabaseHelper dbHelper = new HandbookDatabaseHelper(context);
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        return database.rawQuery(courseQuery, null);
    }

    private static Cursor getPhDCourseCursor(Context context, int semesterID, int programID) {
        String semesterIDString = String.valueOf(semesterID);
        String programIDString = String.valueOf(programID);
        String courseQuery = "SELECT "
                + Course.course_name +
                " FROM course WHERE " + Course.program_id + " = " + programIDString +
                " AND " + Course.semester_id + " = " + semesterIDString;

        HandbookDatabaseHelper dbHelper = new HandbookDatabaseHelper(context);
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        return database.rawQuery(courseQuery, null);
    }

    private static Cursor getSynopsisCursor(Context context, int course_id) {
        String courseIDString = String.valueOf(course_id);

        String courseQuery = "SELECT " + CourseSynopsis.synopsis_id + "," + CourseSynopsis.synopsis_name +
                " FROM course_synopsis WHERE " + CourseSynopsis.course_id + " = " + courseIDString;

        HandbookDatabaseHelper dbHelper = new HandbookDatabaseHelper(context);
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        //cursor.setNotificationUri();
        return database.rawQuery(courseQuery, null);
    }

    private static Cursor getRequirementCursor(Context context, int requirementTypeID, int ProgramID) {
        String requirementTypeIDString = String.valueOf(requirementTypeID);
        String programIDString = String.valueOf(ProgramID);

        String requirementQuery = "SELECT " + Requirement.requirement_id + "," + Requirement.requirement_name +
                " FROM requirement WHERE " + Requirement.requirement_type_id + " = " + requirementTypeIDString +
                " AND " + Requirement.program_id + " = " + programIDString;

        HandbookDatabaseHelper dbHelper = new HandbookDatabaseHelper(context);
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        return database.rawQuery(requirementQuery, null);
    }

    private static Cursor getDurationCursor(Context context, int ProgramID) {

        String programIDString = String.valueOf(ProgramID);

        String durationQuery = "SELECT " + ProgramDuration.duration_id + "," + ProgramDuration.duration_name +
                " FROM duration WHERE " +
                ProgramDuration.duration_program + " = " + programIDString;

        HandbookDatabaseHelper dbHelper = new HandbookDatabaseHelper(context);
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        return database.rawQuery(durationQuery, null);
    }

    private static Cursor getBenchmarkCursor(Context context, int ProgramID) {

        String programIDString = String.valueOf(ProgramID);

        String benchmarkCursor = "SELECT " + ResearchBenchmark.benchmark_id + "," + ResearchBenchmark.benchmark_name +
                " FROM benchmark WHERE " +
                ResearchBenchmark.benchmark_program + " = " + programIDString;

        HandbookDatabaseHelper dbHelper = new HandbookDatabaseHelper(context);
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        return database.rawQuery(benchmarkCursor, null);
    }

    private static Cursor getStaffCursor(Context context) {

        String staffCursor = "SELECT " + AcademicStaff.staff_id + "," + AcademicStaff.staff_name +
                "," + AcademicStaff.staff_qualification + "," + AcademicStaff.staff_rank + ","
                + AcademicStaff.staff_specialization +
                " FROM staff";
        HandbookDatabaseHelper dbHelper = new HandbookDatabaseHelper(context);
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        return database.rawQuery(staffCursor, null);
    }

    private static Cursor getSpecificStaffCursor(Context context, int staffID) {

        String StaffID = String.valueOf(staffID);

        String staffCursor = "SELECT " + AcademicStaff.staff_id + "," + AcademicStaff.staff_name + ","
                + AcademicStaff.staff_qualification + "," + AcademicStaff.staff_rank + ","
                + AcademicStaff.staff_specialization +
                " FROM staff WHERE " +
                AcademicStaff.staff_id + " = " + StaffID;

        HandbookDatabaseHelper dbHelper = new HandbookDatabaseHelper(context);
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        return database.rawQuery(staffCursor, null);
    }

}
