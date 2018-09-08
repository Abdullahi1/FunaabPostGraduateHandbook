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
import com.example.abdullahi.funaabpost_graduatehandbook.adapters.DurationRecyclerViewAdapter;
import com.example.abdullahi.funaabpost_graduatehandbook.data.ProgramDuration;
import com.example.abdullahi.funaabpost_graduatehandbook.provider.HandbookLibrary;

import java.util.List;

public class DurationFragment extends Fragment {

    int programID;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public DurationFragment() {
    }

    @SuppressWarnings("unused")
    public static DurationFragment newInstance(int programID) {
        DurationFragment fragment = new DurationFragment();
        Bundle args = new Bundle();
        args.putInt("ProgramID", programID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            programID = getArguments().getInt("ProgramID");

        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_duration_list, container, false);


        //noinspection ConstantConditions
        getActivity().setTitle("Program Duration");


        List<ProgramDuration> programDurationList = HandbookLibrary.getDuration(getContext(), programID);


        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new DurationRecyclerViewAdapter(programDurationList));
            //noinspection ConstantConditions
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        }
        return view;
    }
}
