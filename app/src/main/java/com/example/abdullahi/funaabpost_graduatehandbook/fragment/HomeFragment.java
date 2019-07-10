package com.example.abdullahi.funaabpost_graduatehandbook.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.utils.HandbookPreferences;

import org.w3c.dom.Text;


public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        //noinspection ConstantConditions
        Context context =getContext();
        //noinspection ConstantConditions
        getActivity().setTitle("Home");

        TextView staticIntroLabel = view.findViewById(R.id.staticIntroLabel);
        TextView staticIntroValue = view.findViewById(R.id.staticIntroValue);
        TextView staticPhilosophyLabel = view.findViewById(R.id.staticPhilosophyLabel);
        TextView staticPhilosophyValue = view.findViewById(R.id.staticPhilosophyValue);
        TextView staticObjectiveLabel = view.findViewById(R.id.staticObjectiveLabel);
        TextView staticObjectiveValue = view.findViewById(R.id.staticObjectiveValue);
        TextView staticMissionLabel = view.findViewById(R.id.staticMissionLabel);
        TextView staticMissionValue = view.findViewById(R.id.staticMissionValue);
        TextView staticVisionLabel = view.findViewById(R.id.staticVisionLabel);
        TextView staticVisionValue = view.findViewById(R.id.staticVisionValue);

        staticIntroLabel.setTextSize(HandbookPreferences.getFontSize(context) + 7);
        staticIntroValue.setTextSize(HandbookPreferences.getFontSize(context));
        staticPhilosophyLabel.setTextSize(HandbookPreferences.getFontSize(context) + 7);
        staticPhilosophyValue.setTextSize(HandbookPreferences.getFontSize(context));
        staticObjectiveLabel.setTextSize(HandbookPreferences.getFontSize(context) + 7);
        staticObjectiveValue.setTextSize(HandbookPreferences.getFontSize(context));
        staticMissionLabel.setTextSize(HandbookPreferences.getFontSize(context) + 7);
        staticMissionValue.setTextSize(HandbookPreferences.getFontSize(context));
        staticVisionLabel.setTextSize(HandbookPreferences.getFontSize(context) + 7);
        staticVisionValue.setTextSize(HandbookPreferences.getFontSize(context));
        return view;
    }

}
