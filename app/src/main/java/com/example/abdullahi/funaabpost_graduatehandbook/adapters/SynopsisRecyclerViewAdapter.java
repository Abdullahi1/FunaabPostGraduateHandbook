package com.example.abdullahi.funaabpost_graduatehandbook.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.data.Course;
import com.example.abdullahi.funaabpost_graduatehandbook.data.CourseSynopsis;
import com.example.abdullahi.funaabpost_graduatehandbook.utils.HandbookPreferences;

import java.util.List;

public class SynopsisRecyclerViewAdapter extends RecyclerView.Adapter<SynopsisRecyclerViewAdapter.ViewHolder> {

    private final List<CourseSynopsis> synopses;
    private final Context context;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    Course course;

    public SynopsisRecyclerViewAdapter(List<CourseSynopsis> synopses, Context context,Course course) {
        this.context = context;
        this.synopses = synopses;
        this.course = course;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutId;

        switch (viewType) {

            case TYPE_HEADER: {
                layoutId = R.layout.synopsis_detail;
                break;
            }

            case TYPE_ITEM: {
                layoutId = R.layout.fragment_details;
                break;
            }

            default:
                throw new IllegalArgumentException("Invalid view type, value of " + viewType);
        }

        View view = LayoutInflater.from(parent.getContext())
                .inflate(layoutId, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position == 0) {
            String courseName = "Course Name : " + course.getCourseName();
            String courseCode = "Course Code : " + course.getCourseCode();
            String courseUnit = "Course Unit : " + String.valueOf(course.getUnit());
            String courseType = "Course Type : " + getCourseType(course.getType());
            holder.Tv_synopsisCourseName.setText(courseName);
            holder.Tv_synopsisCourseCode.setText(courseCode);
            holder.Tv_synopsisCourseUnit.setText(courseUnit);
            holder.Tv_synopsisCourseType.setText(courseType);
        } else {

            final CourseSynopsis entry = synopses.get(getNewItemPosition(position));
            holder.Tv_synopsisName.setTextSize(HandbookPreferences.getFontSize(context));
            holder.Tv_synopsisName.setText(entry.getSynopsisName());
        }
    }

    @Override
    public int getItemCount() {
        return synopses.size() + 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView Tv_synopsisName;
        final TextView Tv_synopsisCourseName;
        final TextView Tv_synopsisCourseCode;
        final TextView Tv_synopsisCourseUnit;
        final TextView Tv_synopsisCourseType;


        ViewHolder(View view) {
            super(view);
            mView = view;
            Tv_synopsisName = view.findViewById(R.id.synopsisName);
            Tv_synopsisCourseName = view.findViewById(R.id.synopsis_Course_name);
            Tv_synopsisCourseCode = view.findViewById(R.id.synopsis_Course_code);
            Tv_synopsisCourseUnit = view.findViewById(R.id.synopsis_Course_unit);
            Tv_synopsisCourseType = view.findViewById(R.id.synopsis_Course_type);

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    private int getNewItemPosition(int position) {
        return position - 1;
    }

    private String getCourseType(int courseTypeID) {
        String typeName;
        switch (courseTypeID) {
            case 1:
                typeName = "Compulsory";
                break;
            case 2:
                typeName = "Elective";
                break;
            default:
                typeName = "Undefined";
        }

        return typeName;
    }
}