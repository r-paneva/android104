package com.example.rumy.android104.views.SuperheroCreate;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    private EditText newHeroName;
    private Button buttonCreateNewHero;
    private EditText newHeroBorn;
    private EditText newHeroDescription;

    public SuperheroCreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_superhero_create, container, false);



//        mSuperheroesRepository = new FirebaseRepository<>(Superhero.class);
//        mDb = FirebaseFirestore.getInstance();
//
//        //Create Reference with the screen widget component
//
//        newHeroName.findViewById(R.id.eTxt_input_name);
//        newHeroBorn.findViewById(R.id.eTxt_input_born);
//        newHeroDescription.findViewById(R.id.eTxt_description);
//        buttonCreateNewHero.findViewById(R.id.btn_create_new_hero);
//
//        //Create Button Select listener
//
//        buttonCreateNewHero.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // Read values
//
//                String name = String.valueOf(newHeroName.getText());
//                String born = String.valueOf(newHeroBorn.getText());
//                String description = String.valueOf(newHeroDescription.getText());
//
//                // Add Hero in Firebase
//
//                Superhero hero = new Superhero(name, born, description);
//                mDb.collection("superheros").add(hero);
//
//                //Display result
//
//                Toast.makeText(getContext(),
//                        String.format("Hero %s was created.", name),
//                        Toast.LENGTH_LONG)
//                        .show();
//            }
//        });


//
//        Superhero hero = new Superhero("Storm", "Ororo Munroe");
//        mDb.collection("superheros").add(hero);



        return view;
    }

    public static SuperheroCreateFragment instance(){return new SuperheroCreateFragment();}

}
