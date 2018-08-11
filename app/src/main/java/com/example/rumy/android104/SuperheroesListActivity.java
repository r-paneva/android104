package com.example.rumy.android104;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.example.rumy.android104.uiutility.Navigator;

public class SuperheroesListActivity extends Activity implements Navigator {

    private SuperheroesListFragment mSuperheroesListFragment;
    private boolean mIsPhone;
    private SuperheroesDetailsFragment mSuperheroDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superheroes_list);

        mSuperheroesListFragment = SuperheroesListFragment.instance();
        mSuperheroesListFragment.setNavigator(this);

        mIsPhone =
                findViewById(R.id.content_details) == null;

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();
        transaction.replace(R.id.content, mSuperheroesListFragment);

        if (!mIsPhone) {
            mSuperheroDetailsFragment = SuperheroesDetailsFragment.instance();
            transaction.replace(R.id.content_details, mSuperheroDetailsFragment);

        }
        transaction.commit();
    }

    @Override
    public void navigateWith(String superhero) {
        if (mIsPhone) {
            Intent intent = new Intent(
                    this,
                    SuperheroesDetailsActivity.class
            );
            intent.putExtra("SUPERHERO_NAME", superhero);
            startActivity(intent);
        } else {
            mSuperheroDetailsFragment.setSuperhero(superhero);
        }
    }
}
