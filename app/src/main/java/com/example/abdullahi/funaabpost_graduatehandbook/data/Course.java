package com.example.abdullahi.funaabpost_graduatehandbook.data;

import android.provider.BaseColumns;

public class Course implements BaseColumns {


    public static final String course_code = "course_code";
    public static final String course_unit = "Units";
    public static final String semester_id = "semester_id";
    public static final String course_abbreviation = "Abbreviation";
    public static final String course_name = "courseName";
    public static final String course_type_id = "course_type_id";
    public static final String program_id = "program_id";
    public static final String ID = "id";

    private int Id;
    private String courseCode;
    private final String courseName;
    private String abbreviation;
    private int unit;
    private int type;

    public Course(String courseCode, String courseName, String abbreviation, int unit, int type) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.abbreviation = abbreviation;
        this.unit = unit;
        this.type = type;
    }

    public Course(int id, String courseCode, String courseName, String abbreviation,
                  int unit) {
        super();
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.abbreviation = abbreviation;
        this.unit = unit;
        this.Id = id;
    }

    public Course(String courseName) {
        super();
        this.courseName = courseName;
    }



    public int getId() {
        return Id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public int getUnit() {
        return unit;
    }

    public int getType() {
        return type;
    }
}
