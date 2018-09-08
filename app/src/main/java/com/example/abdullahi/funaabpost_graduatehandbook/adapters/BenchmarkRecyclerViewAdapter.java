package com.example.abdullahi.funaabpost_graduatehandbook.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.data.ResearchBenchmark;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BenchmarkRecyclerViewAdapter extends RecyclerView.Adapter<BenchmarkRecyclerViewAdapter.ViewHolder> {


    private final List<ResearchBenchmark> researchBenchmarks;

    public BenchmarkRecyclerViewAdapter(List<ResearchBenchmark> benchmarks) {
        researchBenchmarks = benchmarks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_benchmark, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        ResearchBenchmark benchmark = researchBenchmarks.get(position);

        holder.benchmarkName.setText(benchmark.getBenchmarkName());
    }

    @Override
    public int getItemCount() {
        return researchBenchmarks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;

        @BindView(R.id.benchmarkName)
        TextView benchmarkName;

        ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }


    }
}
