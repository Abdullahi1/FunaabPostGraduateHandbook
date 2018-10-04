package com.example.abdullahi.funaabpost_graduatehandbook.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.data.ProgramDuration;
import com.example.abdullahi.funaabpost_graduatehandbook.utils.HandbookPreferences;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DurationRecyclerViewAdapter extends RecyclerView.Adapter<DurationRecyclerViewAdapter.ViewHolder> {

    private final List<ProgramDuration> durationList;
    private final Context context;


    public DurationRecyclerViewAdapter(List<ProgramDuration> durations , Context context) {
        this.context = context;
        durationList = durations;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_duration, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        ProgramDuration entry = durationList.get(position);
        holder.durationName.setTextSize(HandbookPreferences.getFontSize(context));
        holder.durationName.setText(entry.getDurationName());

    }

    @Override
    public int getItemCount() {
        return durationList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        @BindView(R.id.durationName)
        TextView durationName;

        ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }


    }

}
