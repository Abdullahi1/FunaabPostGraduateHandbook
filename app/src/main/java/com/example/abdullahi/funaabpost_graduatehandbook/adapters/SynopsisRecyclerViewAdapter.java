package com.example.abdullahi.funaabpost_graduatehandbook.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.data.CourseSynopsis;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SynopsisRecyclerViewAdapter extends RecyclerView.Adapter<SynopsisRecyclerViewAdapter.ViewHolder> {

    private final List<CourseSynopsis> synopses;

    public SynopsisRecyclerViewAdapter(List<CourseSynopsis> synopses) {
        this.synopses = synopses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_details, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final CourseSynopsis entry = synopses.get(position);

        holder.Tv_synopsisName.setText(entry.getSynopsisName());
    }

    @Override
    public int getItemCount() {
        return synopses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        @BindView(R.id.synopsisName)
        TextView Tv_synopsisName;

        ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }
    }
}
