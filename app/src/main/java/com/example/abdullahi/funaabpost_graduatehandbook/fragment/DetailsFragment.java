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
import com.example.abdullahi.funaabpost_graduatehandbook.adapters.SynopsisRecyclerViewAdapter;
import com.example.abdullahi.funaabpost_graduatehandbook.data.CourseSynopsis;
import com.example.abdullahi.funaabpost_graduatehandbook.provider.HandbookLibrary;

import java.util.List;


public class DetailsFragment extends Fragment {

    int courseId;

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(int position) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt("Position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            courseId = getArguments().getInt("Position");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details_list, container, false);

        //noinspection ConstantConditions
        getActivity().setTitle("Course Synopsis");


        List<CourseSynopsis> synopses = HandbookLibrary.getSynopsis(getContext(), courseId);

        SynopsisRecyclerViewAdapter adapter = new SynopsisRecyclerViewAdapter(synopses);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(adapter);
            //noinspection ConstantConditions
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        }

        return view;
    }


}
