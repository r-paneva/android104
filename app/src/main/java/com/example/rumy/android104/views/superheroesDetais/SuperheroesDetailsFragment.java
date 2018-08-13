package com.example.rumy.android104.views.superheroesDetais;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rumy.android104.R;


public class SuperheroesDetailsFragment extends android.app.Fragment{


    private String mSuperhero;
    private TextView mSuperheroTextView;
    private Intent intent;

    public SuperheroesDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_superheroes_details, container, false);
        mSuperheroTextView = view.findViewById(R.id.tv_superhero);
        mSuperheroTextView.setText(mSuperhero);

        return view;
    }

    public static SuperheroesDetailsFragment instance() {
        return new SuperheroesDetailsFragment();
    }

    public void setSuperhero(String superhero) {
        mSuperhero = superhero;
        if (mSuperheroTextView == null) {
            return;
        }
        mSuperheroTextView.setText(superhero);
    }
}
