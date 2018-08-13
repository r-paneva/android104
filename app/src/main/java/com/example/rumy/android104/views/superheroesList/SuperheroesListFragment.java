package com.example.rumy.android104.views.superheroesList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.rumy.android104.R;
import com.example.rumy.android104.models.Superhero;
import com.example.rumy.android104.repositories.FirebaseRepository;
import com.example.rumy.android104.repositories.base.Repository;
import com.example.rumy.android104.uiutility.Navigator;
import com.google.firebase.firestore.FirebaseFirestore;

public class SuperheroesListFragment extends android.app.Fragment implements AdapterView.OnItemClickListener {

    private Navigator mNavigator;
    private ListView mSuperheroesListView;
    private ArrayAdapter<String> mSuperheroesAdapter;
    private FirebaseFirestore mDb;
    private Repository<Superhero> mSuperheroesRepository;

    public SuperheroesListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_superheroes_list, container, false);

        mDb = FirebaseFirestore.getInstance();

        mSuperheroesListView = view.findViewById(R.id.lv_superheroes);
        mSuperheroesAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1);

        mSuperheroesListView.setAdapter(mSuperheroesAdapter);
        mSuperheroesListView.setOnItemClickListener(this);
        mSuperheroesRepository = new FirebaseRepository<>(Superhero.class);

        mSuperheroesRepository.getAll(superheroes -> {
            for (Superhero superhero : superheroes) {
                mSuperheroesAdapter.add(superhero.name);
            }

        });
//        Repository<Power> powersRepository = new FirebaseRepository<>(Power.class);

//        mDb.collection("superheros")
//                .get()
//                .addOnCompleteListener(task -> {
//                        List<Superhero> superheroes = task.getResult().toObjects(Superhero.class);
//                        for(Superhero hero: superheroes ){
////                            if(hero.name=="Wonder Woman"){
////                                String key=hero.getKey();
////                                hero.getRef().removeValue();
////                                hero.parent().setValue(null);
////                        }
//                            mSuperheroesAdapter.add(hero.name);
//                        } });
//        Superhero hero = new Superhero("Wonder Woman", "Diana Prince");
//        mDb.collection("superheros").add(hero);

//        Data superheroData = new Data(Superhero.class);
//        superheroData.getAll();
//        superheroData.add(hero);
//        Data powerData = new Data(Power.class);

        return view;
    }


//    EventListener eventListener = new EventListener() {
//
//        public void duplicateRecord(Superhero hero) {
//            if (hero.name=="Wonder Woman") {
//                key = Object.keys(hero)[0];
//                myRef.child(key).setValue(null);
//
//            }
//        }
//    }

    public static SuperheroesListFragment instance() {
        return new SuperheroesListFragment();
    }

    public void setNavigator(Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String superhero = mSuperheroesAdapter.getItem(i);
        mNavigator.navigateWith(superhero);
    }
}