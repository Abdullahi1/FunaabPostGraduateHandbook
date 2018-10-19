package com.example.abdullahi.funaabpost_graduatehandbook.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.abdullahi.funaabpost_graduatehandbook.fragment.HomeFragment;
import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.utils.HandbookPreferences;
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.StaffFragment;
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.AllStaffFragment;
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.DetailsFragment;
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.PhDCourseFragment;
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.SSCourseFragment;
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.courseFragment;

public class StartPageActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //program = HandbookPreferences.getProgramID(this);

        //chooseFragment(program);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, HomeFragment.newInstance()).commit();


//        if (program == 4) {
//            Menu nav_menu = navigationView.getMenu();
//            nav_menu.findItem(R.id.nav_second_semester).setVisible(false);
//            nav_menu.findItem(R.id.nav_first_semester).setTitle("Course Work");
//        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
            showCloseDialogue();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
//            case R.id.nav_first_semester:
//
//                chooseFragment(program);
//
//                break;
//            case R.id.nav_second_semester: {
//
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragmentContainer,
//                                SSCourseFragment.newInstance(program))
//                        .commit();
//
//                break;
//            }
            case R.id.nav_pgd: {

                Intent intent = new Intent(this,ProgramActivity.class);
                intent.putExtra("ProgramID",1);
                startActivity(intent);
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragmentContainer,
//                                ProgramFragment.newInstance())
//                        .commit();

                break;
            }
            case R.id.nav_msc: {

                Intent intent = new Intent(this,ProgramActivity.class);
                intent.putExtra("ProgramID",2);
                startActivity(intent);

//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragmentContainer,
//                                GradReqFragment.newInstance(program))
//                        .commit();

                break;
            }
            case R.id.nav_mict: {
                Intent intent = new Intent(this,ProgramActivity.class);
                intent.putExtra("ProgramID",3);
                startActivity(intent);

//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragmentContainer,
//                                BenchmarkFragment.newInstance(program))
//                        .commit();

                break;
            }
            case R.id.nav_phd: {
                Intent intent = new Intent(this,ProgramActivity.class);
                intent.putExtra("ProgramID",4);
                startActivity(intent);

//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragmentContainer,
//                                DurationFragment.newInstance(program))
//                        .commit();

                break;
            }
            case R.id.nav_staff: {
                Intent intent= new Intent(this,StaffActivity.class);
                startActivity(intent);
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragmentContainer, AllStaffFragment.newInstance()).commit();
                break;
            }
            case R.id.nav_home: {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, HomeFragment.newInstance()).commit();
                break;
            }

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    @Override
//    public void onListFragmentInteraction(int position) {
//
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragmentContainer,
//                        DetailsFragment.newInstance(position))
//                .addToBackStack(null)
//                .commit();
//
//    }

    public void showCloseDialogue() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.app_name);

        builder.setMessage("Are you Sure you Want to Close the Application");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //System.exit(0);
                StartPageActivity.super.onBackPressed();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (dialog != null) {

                    dialog.dismiss();

                }

            }
        });

        AlertDialog dialog = builder.create();

        dialog.show();
    }

    private void chooseFragment(int program) {

        switch (program) {
            case 4:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer,
                                PhDCourseFragment.newInstance(program))
                        .commit();
                break;
            default:

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer,
                                courseFragment.newInstance(program))
                        .commit();
                break;

        }
    }

//    @Override
//    public void onItemClick(int position) {
//
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragmentContainer,
//                        StaffFragment.newInstance(position))
//                .addToBackStack(null).commit();
//    }



}



