package com.example.rumy.android104.views.superheroCreate;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.rumy.android104.R;
import com.example.rumy.android104.models.Superhero;
import com.example.rumy.android104.repositories.FirebaseRepository;
import com.example.rumy.android104.repositories.base.Repository;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuperheroCreateFragment<T> extends android.app.Fragment {


    private Repository<Superhero> mSuperheroesRepository;
    private ArrayAdapter<String> mSuperheroesAdapter;
    private FirebaseFirestore mDb;
    private TextView mSuperheroTextView;

    public SuperheroCreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_superhero_create, container, false);

        mSuperheroesRepository = new FirebaseRepository<>(Superhero.class);
        mDb = FirebaseFirestore.getInstance();


        Superhero hero = new Superhero("Storm", "Ororo Munroe");
        mDb.collection("superheros").add(hero);

        mSuperheroTextView = view.findViewById(R.id.tv_new_hero_added);
        mSuperheroTextView.setText("Hero "+ hero.name+" was added");


        return view;
    }

    public static SuperheroCreateFragment instance(){return new SuperheroCreateFragment();}

}
