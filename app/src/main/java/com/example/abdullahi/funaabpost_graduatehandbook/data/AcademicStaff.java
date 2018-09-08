package com.example.abdullahi.funaabpost_graduatehandbook.data;

import com.example.abdullahi.funaabpost_graduatehandbook.R;

public class AcademicStaff {

    public static final String staff_id = "id";
    public static final String staff_name = "name";
    public static final String staff_rank = "rank";
    public static final String staff_specialization = "specialization";
    public static final String staff_qualification = "qualification";

    public static final int [] image = {R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father};

    private final int id;
    private final String name;
    private final int rank;
    private final String specialization;
    private final String qualification;

    public AcademicStaff(int id, String name, int rank, String specialization, String qualification) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.specialization = specialization;
        this.qualification = qualification;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getQualification() {
        return qualification;
    }
}
