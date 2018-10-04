package com.example.abdullahi.funaabpost_graduatehandbook.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.data.Requirement;
import com.example.abdullahi.funaabpost_graduatehandbook.utils.HandbookPreferences;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AdmReqRecyclerViewAdapter extends RecyclerView.Adapter<AdmReqRecyclerViewAdapter.ViewHolder> {

    private final List<Requirement> requirements;
    private final Context context;
    public AdmReqRecyclerViewAdapter(List<Requirement> requirements , Context context) {
        this.context = context;
        this.requirements = requirements;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_requirement, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Requirement entry = requirements.get(position);
        holder.Tv_requirementName.setTextSize(HandbookPreferences.getFontSize(context));
        holder.Tv_requirementName.setText(entry.getRequirementName());
    }

    @Override
    public int getItemCount() {
        return requirements.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        @BindView(R.id.admReqName)
        TextView Tv_requirementName;

        ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }


    }

}
