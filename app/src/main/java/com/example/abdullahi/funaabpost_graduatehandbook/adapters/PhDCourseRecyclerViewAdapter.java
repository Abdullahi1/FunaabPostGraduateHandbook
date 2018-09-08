package com.example.abdullahi.funaabpost_graduatehandbook.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.data.Course;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PhDCourseRecyclerViewAdapter extends RecyclerView.Adapter<PhDCourseRecyclerViewAdapter.ViewHolder> {

    private final List<Course> courses;

    public PhDCourseRecyclerViewAdapter(List<Course> course) {
        courses = course;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_phdcourse, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        Course entry = courses.get(position);
        String courseName = entry.getCourseName();
        holder.CourseName.setText(courseName);


    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        @BindView(R.id.phdCourseName)
        TextView CourseName;

        ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);

        }

    }
}
