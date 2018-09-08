package com.example.abdullahi.funaabpost_graduatehandbook.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.data.Course;
import com.example.abdullahi.funaabpost_graduatehandbook.dummy.DummyContent.DummyItem;
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.SSCourseFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */

public class SSRecyclerViewAdapter extends RecyclerView.Adapter<SSRecyclerViewAdapter.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private final OnListFragmentInteractionListener mListener;
    private final List<Course> courses;
    private final int program;

    public SSRecyclerViewAdapter(List<Course> course, OnListFragmentInteractionListener listener, int programID) {
        courses = course;
        mListener = listener;
        program = programID;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        int layoutId;

        switch (viewType) {

            case TYPE_HEADER: {
                layoutId = R.layout.header_layout;
                break;
            }

            case TYPE_ITEM: {
                layoutId = R.layout.fragment_sscourse;
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {


        if (position == 0) {

            holder.Tv_header.setText(getHeader(program));

        } else {
            final Course entry = courses.get(getNewItemPosition(position));

            holder.Tv_courseCode.setText(entry.getCourseCode());

            holder.Tv_courseName.setText(entry.getCourseName());

            holder.Tv_courseAbbr.setText(entry.getAbbreviation());


            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mListener) {

                        // Notify the active callbacks interface (the activity, if the
                        // fragment is attached to one) that an item has been selected.

                        int id = entry.getId();
                        mListener.onListFragmentInteraction(id);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return courses.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    private String getHeader(int programID) {
        String programName = null;
        String content;
        switch (programID) {
            case 1:
                programName = "Post-Graduate Diploma (PGD)";
                break;
            case 2:
                programName = "Academic Master (M.Sc.)";
                break;
            case 3:
                programName = "Professional Masters (M. ICT)";
                break;
            case 4:
                programName = "PHD";
                break;
        }
        content = "The Second Semester Courses For The " + programName + " Programme Are:";
        return content;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    private int getNewItemPosition(int position) {
        return position - 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView Tv_courseCode;
        final TextView Tv_courseName;
        final TextView Tv_courseAbbr;
        final TextView Tv_header;

        ViewHolder(View view) {
            super(view);
            mView = view;
            Tv_courseCode = view.findViewById(R.id.ss_courseCode);
            Tv_courseName = view.findViewById(R.id.ss_course_name);
            Tv_courseAbbr = view.findViewById(R.id.ss_abbreviation);
            Tv_header = view.findViewById(R.id.headerTitle1);
        }


    }
}
