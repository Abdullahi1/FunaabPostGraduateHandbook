package com.example.abdullahi.funaabpost_graduatehandbook.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.data.Requirement;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;



public class GradReqRecyclerViewAdapter extends RecyclerView.Adapter<GradReqRecyclerViewAdapter.ViewHolder> {

    private final List<Requirement> requirements;

    public GradReqRecyclerViewAdapter(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_gradreq, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Requirement entry = requirements.get(position);

        holder.Tv_requirementName.setText(entry.getRequirementName());
    }

    @Override
    public int getItemCount() {
        return requirements.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        @BindView(R.id.gradReqName)
        TextView Tv_requirementName;

        ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }

    }
}
