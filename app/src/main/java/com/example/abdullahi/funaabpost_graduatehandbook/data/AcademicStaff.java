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
        mapImage.put("Akinwale",R.mipmap.prof_akinwale);
        mapImage.put("Folorunso",R.mipmap.prof_folorunso);
        mapImage.put("Sodiya",R.mipmap.prof_sodiya);
        mapImage.put("Ojesanmi",R.mipmap.dr_ojesanmi);
        mapImage.put("Onashoga",R.mipmap.dr_onashoga);
        mapImage.put("Arogundade",R.mipmap.dr_arogundade);
        mapImage.put("Vincent",R.mipmap.dr_vincent);
        mapImage.put("Ibrahalu",R.mipmap.dr_ibrahalu);
        mapImage.put("Abayomi-Alli",R.mipmap.dr_alli);
        mapImage.put("Aborisade",R.mipmap.dr_aborisade);
        mapImage.put("Ojo",R.mipmap.dr_ojo);
        mapImage.put("Salako",R.mipmap.salako);
        mapImage.put("Tinubu",R.mipmap.oloruntobaco);
        mapImage.put("Adejimi",R.mipmap.adejimi);
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
