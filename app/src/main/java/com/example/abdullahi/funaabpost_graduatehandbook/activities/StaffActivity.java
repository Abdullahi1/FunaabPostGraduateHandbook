package com.example.abdullahi.funaabpost_graduatehandbook.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.abdullahi.funaabpost_graduatehandbook.R;
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.AllStaffFragment;
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.ProgramFragment;
import com.example.abdullahi.funaabpost_graduatehandbook.fragment.StaffFragment;

public class StaffActivity extends AppCompatActivity
        implements AllStaffFragment.OnListFragmentInteractionListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);

        if (findViewById(R.id.staffFragmentContainer) != null){
            if (savedInstanceState != null) {
                return;
            }
        }

        getSupportFragmentManager().beginTransaction()
                .add(R.id.staffFragmentContainer, AllStaffFragment.newInstance()).commit();

    }

    @Override
    public void onItemClick(int position) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.staffFragmentContainer,
                        StaffFragment.newInstance(position))
                .addToBackStack(null).commit();
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
