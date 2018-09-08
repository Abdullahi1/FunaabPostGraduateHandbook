package com.example.abdullahi.funaabpost_graduatehandbook.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.adapters.PhDCourseRecyclerViewAdapter;
import com.example.abdullahi.funaabpost_graduatehandbook.data.Course;
import com.example.abdullahi.funaabpost_graduatehandbook.provider.HandbookLibrary;

import java.util.List;


public class PhDCourseFragment extends Fragment {

    int semester;
    int programID;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */

    public PhDCourseFragment() {
    }

    @SuppressWarnings("unused")
    public static PhDCourseFragment newInstance(int programID) {
        PhDCourseFragment fragment = new PhDCourseFragment();
        Bundle args = new Bundle();
        args.putInt("semester", 1);
        args.putInt("programID", programID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            semester = getArguments().getInt("semester");
            programID = getArguments().getInt("programID");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phdcourse_list, container, false);


        //noinspection ConstantConditions
        getActivity().setTitle("Ph. D. Course Work");


        List<Course> coursesList = HandbookLibrary.getCoursesForPhD(getContext(), semester, programID);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new PhDCourseRecyclerViewAdapter(coursesList));
            //noinspection ConstantConditions
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        }
        return view;
    }


}
