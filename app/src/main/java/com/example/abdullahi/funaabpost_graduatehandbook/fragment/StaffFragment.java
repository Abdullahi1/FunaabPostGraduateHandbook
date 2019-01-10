package com.example.abdullahi.funaabpost_graduatehandbook.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.data.AcademicStaff;
import com.example.abdullahi.funaabpost_graduatehandbook.provider.HandbookLibrary;




public class StaffFragment extends Fragment {

    private static final String ARG_PARAM1 = "StaffID";

    private int staffID;

    public StaffFragment() {
        // Required empty public constructor
    }

    public static StaffFragment newInstance(int staffID) {
        StaffFragment fragment = new StaffFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, staffID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            staffID = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_staff_specific, container, false);

        AcademicStaff staff = HandbookLibrary.getSpecificStaff(getContext(), staffID);

        ImageView mLecturerImage = view.findViewById(R.id.lecturerPicture);
        TextView mLecturerName = view.findViewById(R.id.lecturerName);
        TextView mLecturerRank = view.findViewById(R.id.lecturerRank);
        TextView mLecturerQualification = view.findViewById(R.id.lecturerQualification);
        TextView mLecturerSpecialization = view.findViewById(R.id.lecturerSpecialization);

        String staffName = staff.getName();
        int imageID = AcademicStaff.getImage(staffName);
        mLecturerImage.setImageResource(imageID);
        mLecturerName.setText(staffName);
        mLecturerRank.setText(getRank(staff.getRank()));
        mLecturerQualification.setText(staff.getQualification());
        mLecturerSpecialization.setText(staff.getSpecialization());

        //noinspection ConstantConditions
        getActivity().setTitle(staff.getName());

        return view;
    }

    private String getRank(int rankID) {
        String rankName = null;
        switch (rankID) {
            case 1:
                rankName = "Professor";
                break;
            case 2:
                rankName = "Reader";
                break;
            case 3:
                rankName = "Senior Lecturer";
                break;
            case 4:
                rankName = "Lecturer I";
                break;
            case 5:
                rankName = "Lecturer II";
                break;
            case 6:
                rankName = "Assistant Lecturer";
                break;
        }
        return rankName;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            getParentFragment();
        }
        return super.onOptionsItemSelected(item);
    }


}
