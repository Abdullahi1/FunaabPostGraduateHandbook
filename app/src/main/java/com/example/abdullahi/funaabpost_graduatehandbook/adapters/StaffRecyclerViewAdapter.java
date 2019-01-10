package com.example.abdullahi.funaabpost_graduatehandbook.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.data.AcademicStaff;
import com.example.abdullahi.funaabpost_graduatehandbook.dummy.DummyContent.DummyItem;
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.AllStaffFragment.OnListFragmentInteractionListener;

import java.util.List;



/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */

public class StaffRecyclerViewAdapter extends RecyclerView.Adapter<StaffRecyclerViewAdapter.ViewHolder> {

    private final List<AcademicStaff> staffList;
    private final OnListFragmentInteractionListener mListener;
     private final Context context;

    public StaffRecyclerViewAdapter(List<AcademicStaff> academicStaffs, OnListFragmentInteractionListener listener , Context context) {
        this.context = context;
        staffList = academicStaffs;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_staff, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        AcademicStaff.add();
        AcademicStaff staff = staffList.get(position);
        int imageId = AcademicStaff.getImage(staff.getName());
        holder.staffImage.setImageResource(imageId);
        holder.staffName.setText(staff.getName());
        final int staffId = staff.getId();

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.

                    mListener.onItemClick(staffId);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return staffList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final ImageView staffImage;
        final TextView staffName;

        ViewHolder(View view) {
            super(view);
            mView = view;
            staffImage = view.findViewById(R.id.staff_picture);
            staffName = view.findViewById(R.id.staffName);
        }

    }


}
