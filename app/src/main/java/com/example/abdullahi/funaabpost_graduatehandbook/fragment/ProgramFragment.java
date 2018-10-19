package com.example.abdullahi.funaabpost_graduatehandbook.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.activities.CourseActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProgramFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProgramFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProgramFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static int PROGRAM_ID;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ProgramFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ProgramFragment newInstance(int programID) {
        ProgramFragment fragment = new ProgramFragment();
        Bundle args = new Bundle();
        args.putInt("ProgramID", programID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        PROGRAM_ID = getArguments().getInt("ProgramID");
        getActivity().setTitle(setProgramTitle(PROGRAM_ID));
        final View view = inflater.inflate(R.layout.fragment_program, container, false);

        TextView coursesButton = view.findViewById(R.id.program_courses);
        coursesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CourseActivity.class);
                intent.putExtra(CourseActivity.PROGRAM_ID_KEY, PROGRAM_ID);
                startActivity(intent);
            }
        });

        TextView durationButton = view.findViewById(R.id.program_duration);
        durationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFragmentManager() != null) {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.programFragmentContainer,
                                    DurationFragment.newInstance(PROGRAM_ID))
                            .addToBackStack(null)
                            .commit();
                }

            }
        });

        TextView admissionRequirement = view.findViewById(R.id.program_admission_requirement);
        admissionRequirement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFragmentManager() != null) {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.programFragmentContainer,
                                    AdmReqFragment.newInstance(PROGRAM_ID))
                            .addToBackStack(null)
                            .commit();
                }
            }
        });

        TextView graduationRequirement = view.findViewById(R.id.program_graduation_requirement);
        graduationRequirement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFragmentManager() != null) {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.programFragmentContainer,
                                    GradReqFragment.newInstance(PROGRAM_ID))
                            .addToBackStack(null)
                            .commit();
                }
            }
        });

        TextView benchmark = view.findViewById(R.id.program_research_benchmark);
        benchmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFragmentManager() != null) {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.programFragmentContainer,
                                    BenchmarkFragment.newInstance(PROGRAM_ID))
                            .addToBackStack(null)
                            .commit();
                }
            }
        });

        return view;
    }

    private void setupContextMenu(View v) {
        v.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.setHeaderTitle("Requirement");
                //menu.setHeaderIcon(R.drawable.ic_access_time_black_24dp);
                menu.add(0, 0, Menu.CATEGORY_SYSTEM, "Admission Requirement").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        getFragmentManager().beginTransaction()
                                .replace(R.id.programFragmentContainer,
                                        AdmReqFragment.newInstance(PROGRAM_ID))
                                .addToBackStack(null)
                                .commit();
                        return true;
                    }
                });
                menu.add(1, 1, Menu.CATEGORY_SYSTEM, "Graduation Requirement").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        getFragmentManager().beginTransaction()
                                .replace(R.id.programFragmentContainer,
                                        GradReqFragment.newInstance(PROGRAM_ID))
                                .addToBackStack(null)
                                .commit();
                        return false;
                    }
                });
            }
        });
    }

    private String setProgramTitle(int programID) {

        switch (programID) {
            case 1: {
                return "Post Graduate Diploma";
            }
            case 2: {
                return "Master of Science in Computer Science";
            }
            case 3: {
                return "Master of Information and Communication";
            }
            case 4: {
                return "Doctor of Philosophy";
            }
            default: {
                return "";
            }
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
