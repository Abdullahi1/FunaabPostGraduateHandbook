package com.example.abdullahi.funaabpost_graduatehandbook.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.ProgramFragment;

public class ProgramActivity extends AppCompatActivity {
    int PROGRAM_ID;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);
        PROGRAM_ID = getIntent().getIntExtra("ProgramID",1);
//        ImageButton coursesButton = findViewById(R.id.pgd_courses);
//        coursesButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ProgramActivity.this, CourseActivity.class);
//                intent.putExtra(CourseActivity.PROGRAM_ID_KEY,PROGRAM_ID);
//                startActivity(intent);
//            }
//        });
//
//        ImageButton durationButton = findViewById(R.id.pgd_duration);
//        durationButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (getSupportFragmentManager() != null) {
//                    getSupportFragmentManager().beginTransaction()
//                            .add(R.id.programFragmentContainer,
//                                    DurationFragment.newInstance(PROGRAM_ID))
//                            .addToBackStack(null)
//                            .commit();
//                }
//
//            }
//        });
//
//        ImageButton requirement = findViewById(R.id.pgd_requirement);
//        requirement.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ProgramActivity.this,"Long press to choose the requirement type", Toast.LENGTH_LONG).show();
//                //setupContextMenu(v,PROGRAM_ID);
//                registerForContextMenu(v);
//            }
//        });
        if (findViewById(R.id.programFragmentContainer) != null){
            if (savedInstanceState != null) {
                return;
            }
        }

        getSupportFragmentManager().beginTransaction()
                .add(R.id.programFragmentContainer, ProgramFragment.newInstance(PROGRAM_ID)).commit();

    }


//    private void setupContextMenu(View v, final int PROGRAM_ID){
//        v.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
//            @Override
//            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//                menu.setHeaderTitle("Requirement");
//                menu.setHeaderIcon(R.drawable.ic_access_time_black_24dp);
//                menu.add(0, 0, Menu.CATEGORY_SYSTEM, "Admission Requirement")
//                        .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//                        getSupportFragmentManager().beginTransaction()
//                                .replace(R.id.programFragmentContainer,
//                                        AdmReqFragment.newInstance(PROGRAM_ID))
//                                .addToBackStack(null)
//                                .commit();
//                        return true;
//                    }
//                });
//                menu.add(1, 1, Menu.CATEGORY_SYSTEM, "Graduation Requirement")
//                        .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//                        getSupportFragmentManager().beginTransaction()
//                                .replace(R.id.programFragmentContainer,
//                                        GradReqFragment.newInstance(PROGRAM_ID))
//                                .addToBackStack(null)
//                                .commit();
//                        return false;
//                    }
//                });
//            }
//        });
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //getTargetFragment().onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.context_menu_inflater,menu);
//    }

//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
//        int id = item.getItemId();
//
//        switch (id){
//            case R.id.adm_reqq: {
//                getSupportFragmentManager().beginTransaction()
//                        .add(R.id.programFragmentContainer,
//                                AdmReqFragment.newInstance(PROGRAM_ID))
//                        .addToBackStack(null)
//                        .commit();
//                return true;
//            }
//            case R.id.grad_reqq:{
//                getSupportFragmentManager().beginTransaction()
//                        .add(R.id.programFragmentContainer,
//                                GradReqFragment.newInstance(PROGRAM_ID))
//                        .addToBackStack(null)
//                        .commit();
//                return true;
//            }
//
//            default:{
//                return super.onContextItemSelected(item);
//            }
//        }
//    }
}



