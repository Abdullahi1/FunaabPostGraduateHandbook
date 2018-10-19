package com.example.abdullahi.funaabpost_graduatehandbook.activities;

import android.content.Intent;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.adapters.CourseFragmentPagerAdapter;
import com.example.abdullahi.funaabpost_graduatehandbook.data.Course;
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.DetailsFragment;
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.SSCourseFragment;
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.courseFragment;

public class CourseActivity extends AppCompatActivity
        implements courseFragment.OnListFragmentInteractionListener,
        SSCourseFragment.OnListFragmentInteractionListener {

    public static final String COURSE_ID = "course_id";
    public static final String PROGRAM_ID_KEY = "program_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_tab);
        setTitle("Courses");
        Intent intent = getIntent();
        int programID = intent.getIntExtra(PROGRAM_ID_KEY,1);


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        CourseFragmentPagerAdapter adapter = new CourseFragmentPagerAdapter(getSupportFragmentManager(),
                CourseActivity.this,programID);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onListFragmentInteraction(int position) {
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.courseContainer,
//                        DetailsFragment.newInstance(position))
//                .addToBackStack(null)
//                .commit();

        Intent intent = new Intent(this,SynopsisActivity.class);
        intent.putExtra(CourseActivity.COURSE_ID,position);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            //NavUtils.navigateUpFromSameTask(this);
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

