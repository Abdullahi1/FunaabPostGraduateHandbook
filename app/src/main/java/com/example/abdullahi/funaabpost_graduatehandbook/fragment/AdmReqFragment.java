package com.example.abdullahi.funaabpost_graduatehandbook.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.adapters.AdmReqRecyclerViewAdapter;
import com.example.abdullahi.funaabpost_graduatehandbook.data.Requirement;
import com.example.abdullahi.funaabpost_graduatehandbook.provider.HandbookLibrary;

import java.util.List;


public class AdmReqFragment extends Fragment {

    private int requirementID;
    private int programID;

    public AdmReqFragment() {
    }

    @SuppressWarnings("unused")
    public static AdmReqFragment newInstance(int programID) {
        AdmReqFragment fragment = new AdmReqFragment();
        Bundle args = new Bundle();
        args.putInt("requirementID", 1);
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
        View view = inflater.inflate(R.layout.fragment_requirement_list, container, false);

        //noinspection ConstantConditions
        getActivity().setTitle("Admission Requirement");


        List<Requirement> requirements = HandbookLibrary.getRequirement(getContext(), requirementID, programID);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new AdmReqRecyclerViewAdapter(requirements,context));
            //noinspection ConstantConditions
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        }
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //getTargetFragment().onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == android.R.id.home) {
            getParentFragment();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
