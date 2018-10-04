package com.example.abdullahi.funaabpost_graduatehandbook.data;

public class CourseSynopsis {

    public static final String synopsis_id = "id";
    public static final String synopsis_name = "synopsisName";
    public static final String course_id = "course_id";

    private final int id;
    private final String synopsisName;


    public CourseSynopsis(int id, String synopsisName) {
        this.id = id;
        this.synopsisName = synopsisName;

    }

    public int getId() {
        return id;
    }

    public String getSynopsisName() {
        return synopsisName;
    }

}
