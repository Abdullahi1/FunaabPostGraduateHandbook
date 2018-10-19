package com.example.abdullahi.funaabpost_graduatehandbook.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.adapters.SynopsisRecyclerViewAdapter;
import com.example.abdullahi.funaabpost_graduatehandbook.data.Course;
import com.example.abdullahi.funaabpost_graduatehandbook.data.CourseSynopsis;
import com.example.abdullahi.funaabpost_graduatehandbook.provider.HandbookLibrary;

import java.util.List;

public class SynopsisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Course Synopsis");
        setContentView(R.layout.fragment_details_list);
        int courseId = getIntent().getIntExtra(CourseActivity.COURSE_ID, 1);

        List<CourseSynopsis> synopses = HandbookLibrary.getSynopsis(this, courseId);
        Course course  = HandbookLibrary.getSpecificCourse(this,courseId);

        SynopsisRecyclerViewAdapter adapter = new SynopsisRecyclerViewAdapter(synopses, this,course);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.synopsisList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        //noinspection ConstantConditions


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
           // NavUtils.navigateUpFromSameTask(this);
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
