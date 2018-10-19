package com.example.abdullahi.funaabpost_graduatehandbook.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.PhDCourseFragment;
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.SSCourseFragment;
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.courseFragment;

public class CourseFragmentPagerAdapter extends FragmentPagerAdapter {

    int programID;

    private String tabTitles[] = new String[]{"First Semester", "Second Semester"};

    private Context context;

    public CourseFragmentPagerAdapter(FragmentManager fm, Context context, int programID) {
        super(fm);
        this.context = context;
        this.programID = programID;
    }

    public CourseFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: {
                if (programID == 4){
                    return PhDCourseFragment.newInstance(programID);
                }else {
                    return courseFragment.newInstance(programID);
                }
            }
            case 1: {
                return SSCourseFragment.newInstance(programID);

            }
            default: {
                return null;
            }
        }

    }

    @Override
    public int getCount() {
        if (programID == 4){
            return 1;
        }else {
            return 2;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: {
                if (programID == 4) {
                    return "Course Work";
                }else {
                    return context.getResources().getString(R.string.first_semester);
                }
            }
            case 1: {
                return context.getResources().getString(R.string.second_semester);
            }
            default: {
                return null;
            }
        }
    }
}
