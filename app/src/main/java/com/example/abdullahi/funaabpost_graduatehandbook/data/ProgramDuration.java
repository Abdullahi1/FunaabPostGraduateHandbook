package com.example.abdullahi.funaabpost_graduatehandbook.data;

public class ProgramDuration {

    public static final String duration_id = "id";
    public static final String duration_name = "duration_name";
    public static final String duration_program = "program_id";

    private final int id;
    private final String durationName;

    public ProgramDuration(int id, String durationName) {
        this.id = id;
        this.durationName = durationName;
    }

    public int getId() {
        return id;
    }

    public String getDurationName() {
        return durationName;
    }
}
