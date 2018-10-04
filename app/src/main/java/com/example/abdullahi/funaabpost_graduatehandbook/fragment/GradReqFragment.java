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
import com.example.abdullahi.funaabpost_graduatehandbook.adapters.GradReqRecyclerViewAdapter;
import com.example.abdullahi.funaabpost_graduatehandbook.data.Requirement;
import com.example.abdullahi.funaabpost_graduatehandbook.provider.HandbookLibrary;

import java.util.List;


public class GradReqFragment extends Fragment {

    private int requirementID;
    private int programID;

    public GradReqFragment() {
    }

    @SuppressWarnings("unused")
    public static GradReqFragment newInstance(int programID) {
        GradReqFragment fragment = new GradReqFragment();
        Bundle args = new Bundle();
        args.putInt("requirementID", 2);
        args.putInt("ProgramID", programID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            requirementID = getArguments().getInt("requirementID");
            programID = getArguments().getInt("ProgramID");

        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gradreq_list, container, false);


        //noinspection ConstantConditions
        getActivity().setTitle("Graduation Requirement");


        List<Requirement> requirements = HandbookLibrary.getRequirement(getContext(), requirementID, programID);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new GradReqRecyclerViewAdapter(requirements,context));
            //noinspection ConstantConditions
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        }
        return view;
    }

}
