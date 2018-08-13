package com.example.rumy.android104.views.superheroesList;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.rumy.android104.R;
import com.example.rumy.android104.uiutility.Navigator;
import com.example.rumy.android104.views.BaseDrawerActivity;
import com.example.rumy.android104.views.superheroesDetais.SuperheroesDetailsActivity;
import com.example.rumy.android104.views.superheroesDetais.SuperheroesDetailsFragment;


public class SuperheroesListActivity extends BaseDrawerActivity implements Navigator {
    public static final long IDENTIFIER = 1;
    private SuperheroesListFragment mSuperheroesListFragment;
    private boolean mIsPhone;
    private SuperheroesDetailsFragment mSuperheroDetailsFragment;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superheroes_list);

        mSuperheroesListFragment = SuperheroesListFragment.instance();
        mSuperheroesListFragment.setNavigator(this);
        mToolbar = findViewById(R.id.drawer_toolbar);

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

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
        protected Toolbar getDrawerToolbar() {
            return mToolbar ;
        }


    }
