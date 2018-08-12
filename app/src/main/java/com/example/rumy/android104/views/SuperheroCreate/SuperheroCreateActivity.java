package com.example.rumy.android104.views.SuperheroCreate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.rumy.android104.R;
import com.example.rumy.android104.views.BaseDrawerActivity;

public class SuperheroCreateActivity extends BaseDrawerActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superhero_create);
        mToolbar = findViewById(R.id.drawer_toolbar);
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mToolbar;
    }
}
