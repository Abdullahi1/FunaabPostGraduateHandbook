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
import com.example.abdullahi.funaabpost_graduatehandbook.adapters.BenchmarkRecyclerViewAdapter;
import com.example.abdullahi.funaabpost_graduatehandbook.data.ResearchBenchmark;
import com.example.abdullahi.funaabpost_graduatehandbook.provider.HandbookLibrary;

import java.util.List;

public class BenchmarkFragment extends Fragment {

    private int programID;

    public BenchmarkFragment() {
    }


    @SuppressWarnings("unused")
    public static BenchmarkFragment newInstance(int programID) {
        BenchmarkFragment fragment = new BenchmarkFragment();
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
        View view = inflater.inflate(R.layout.fragment_benchmark_list, container, false);


        //noinspection ConstantConditions
        getActivity().setTitle("Research Benchmark");


        List<ResearchBenchmark> researchBenchmarks = HandbookLibrary.getBenchmark(getContext(), programID);


        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new BenchmarkRecyclerViewAdapter(researchBenchmarks,context));
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
            getActivity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
