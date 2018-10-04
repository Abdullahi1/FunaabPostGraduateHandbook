package com.example.abdullahi.funaabpost_graduatehandbook.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.activities.SettingsActivity;
import com.example.abdullahi.funaabpost_graduatehandbook.adapters.StaffRecyclerViewAdapter;
import com.example.abdullahi.funaabpost_graduatehandbook.data.AcademicStaff;
import com.example.abdullahi.funaabpost_graduatehandbook.provider.HandbookLibrary;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class AllStaffFragment extends Fragment {

    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AllStaffFragment() {
    }

    @SuppressWarnings("unused")
    public static AllStaffFragment newInstance() {
        return new AllStaffFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_staff_list, container, false);

        List<AcademicStaff> staffList = HandbookLibrary.getStaff(getContext());
        //noinspection ConstantConditions
        getActivity().setTitle("Academic Staffs");

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (SettingsActivity.isXLargeTablet(context)) {
                int mColumnCount = 2;
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }else {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            }
            recyclerView.setAdapter(new StaffRecyclerViewAdapter(staffList, mListener,context));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnListFragmentInteractionListener {
        void onItemClick(int position);
    }
}
