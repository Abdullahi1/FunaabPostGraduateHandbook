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
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.courseFragment.OnListFragmentInteractionListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */

public class FSRecyclerViewAdapter extends RecyclerView.Adapter<FSRecyclerViewAdapter.ViewHolder> {

    private final OnListFragmentInteractionListener mListener;

    private final List<Course> courses;

    public FSRecyclerViewAdapter(OnListFragmentInteractionListener listener, List<Course> coursesList) {
        mListener = listener;
        this.courses = coursesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_course, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        Course entry = courses.get(position);

        final int id = entry.getId();

        holder.Tv_courseCode.setText(entry.getCourseCode());

        holder.Tv_courseName.setText(entry.getCourseName());

        holder.Tv_courseAbbr.setText(entry.getAbbreviation());


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {

//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an item has been selected.

                    mListener.onListFragmentInteraction(id);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        @BindView(R.id.courseCode)
        TextView Tv_courseCode;
        @BindView(R.id.course_name)
        TextView Tv_courseName;
        @BindView(R.id.abbreviation)
        TextView Tv_courseAbbr;


        ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }


    }

}
