package com.example.abdullahi.funaabpost_graduatehandbook.data;

public class Requirement {
    public static final String requirement_id = "id";
    public static final String requirement_name = "requirement_name";
    public static final String program_id = "program_id";
    public static final String requirement_type_id = "requirement_type_id";

    private final int id;
    private final String requirementName;

    public Requirement(int id, String requirementName) {
        this.id = id;
        this.requirementName = requirementName;
    }

    public int getId() {
        return id;
    }

    public String getRequirementName() {
        return requirementName;
    }


}


