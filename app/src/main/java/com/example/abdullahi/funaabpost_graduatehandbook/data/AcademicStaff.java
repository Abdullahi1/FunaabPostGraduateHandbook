package com.example.abdullahi.funaabpost_graduatehandbook.data;

import com.example.abdullahi.funaabpost_graduatehandbook.R;

import java.util.HashMap;
import java.util.Map;

public class AcademicStaff {

    public static final String staff_id = "id";
    public static final String staff_name = "name";
    public static final String staff_rank = "rank";
    public static final String staff_specialization = "specialization";
    public static final String staff_qualification = "qualification";

    //  public static final int [] image = {R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father,R.drawable.family_father};
    private static final HashMap<String,Integer> mapImage = new HashMap<>();

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

    public static void add(){
        mapImage.put("Akinwale",R.drawable.family_father);
        mapImage.put("Folorunso",R.drawable.family_father);
        mapImage.put("Sodiya",R.drawable.family_father);
        mapImage.put("Ojesanmi",R.drawable.family_father);
        mapImage.put("Onashoga",R.drawable.family_father);
        mapImage.put("Arogundade",R.drawable.family_father);
        mapImage.put("Vincent",R.drawable.family_father);
        mapImage.put("Ibrahalu",R.drawable.family_father);
        mapImage.put("Abayomi-Alli",R.drawable.family_father);
        mapImage.put("Aborisade",R.drawable.family_father);
        mapImage.put("Ojo",R.drawable.family_father);
        mapImage.put("Salako",R.drawable.family_father);
        mapImage.put("Tinubu",R.drawable.family_father);
        mapImage.put("Adejimi",R.drawable.family_father);
    }

    public static int getImage(String name){
        int image = 0;
        String [] splitImage = name.split(" ");
        for (String i  : splitImage){
            if (mapImage.containsKey(i)){
                image = mapImage.get(i);
            }
        }
        return image;
    }
}
