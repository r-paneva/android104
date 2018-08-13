package com.example.rumy.android104.views.superheroesDetais;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rumy.android104.R;

public class SuperheroesDetailsActivity extends AppCompatActivity {
    private SuperheroesDetailsFragment mSuperheroDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superheroes_details);

        Intent intent = getIntent();
        String superhero = intent.getStringExtra("SUPERHERO_NAME");

        mSuperheroDetailFragment = SuperheroesDetailsFragment.instance();
        mSuperheroDetailFragment.setSuperhero(superhero);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mSuperheroDetailFragment)
                .commit();
    }

}